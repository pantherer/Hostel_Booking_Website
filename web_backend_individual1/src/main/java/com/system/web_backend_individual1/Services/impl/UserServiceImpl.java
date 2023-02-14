package com.system.web_backend_individual1.Services.impl;
import com.system.web_backend_individual1.Entity.User;
import com.system.web_backend_individual1.Pojo.UserPojo;
import com.system.web_backend_individual1.Repo.EmailCredRepo;
import com.system.web_backend_individual1.Repo.UserRepo;
import com.system.web_backend_individual1.Services.UserService;
import com.system.web_backend_individual1.config.PasswordEncoderUtil;
import com.system.web_backend_individual1.exception.AppException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;


import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;
    private final JavaMailSender getJavaMailSender;
    private final EmailCredRepo emailCredRepo;
    private final ThreadPoolTaskExecutor taskExecutor;


    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;
    @Override
    public String save_user(UserPojo userPojo){
        User user = new User();
        user.setFullname(userPojo.getFullname());
        user.setPhone(userPojo.getPhone());
        user.setAddress(userPojo.getAddress());
        user.setUsername(userPojo.getUsername());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return "created";
    }
    @Override
    public UserPojo findByUsername(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new UserPojo(user);
    }
    @Override
    public void sendEmail() {
        try {
            Map<String, String> model = new HashMap<>();

            MimeMessage message = getJavaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            Template template = emailConfig.getTemplate("emailTemp.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            mimeMessageHelper.setTo("sendfrom@yopmail.com");
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject("Registration");
            mimeMessageHelper.setFrom("sendTo@yopmail.com");

            taskExecutor.execute(new Thread() {
                public void run() {
                    getJavaMailSender.send(message);
                }
            });
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    @Override
    public String update(UserPojo userPojo) {
        User user = new User();
        if(userPojo.getId()!=null){
            user.setId(userPojo.getId());
        }
        user.setFullname(userPojo.getFullname());
        user.setUsername(userPojo.getUsername());
        user.setPhone(userPojo.getPhone());
        user.setAddress(userPojo.getAddress());
        userRepo.save(user);
        return "created";
    }
    @Override
    public void processPasswordResetRequest(String username) {
        Optional<User> optionalUser = userRepo.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String OTP = generateOTP();
            user.setOTP(OTP);
            userRepo.save(user);
            sendOTPEmail(username, OTP);
        }
    }

    @Override
    public void resetPassword(String username, String OTP, String password) {
        User user = userRepo.findByUsernameAndOTP(username, OTP);
        if (user != null) {
            if (password == null) {
                throw new IllegalArgumentException("Password cannot be null");
            }
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            user.setOTP(null);
            userRepo.save(user);
        } else {
            throw new RuntimeException();
        }
    }

    private String generateOTP() {
        return String.format("%06d", new Random().nextInt(1000000));
    }

    private void sendOTPEmail(String username, String OTP) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(username);
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP for resetting your password is: " + OTP);
        getJavaMailSender.send(message);
    }

}
