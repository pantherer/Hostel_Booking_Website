package com.system.web_backend_individual1.Services.impl;

import com.system.web_backend_individual1.Entity.Message;
import com.system.web_backend_individual1.Pojo.MessagePojo;
import com.system.web_backend_individual1.Repo.MessageRepo;
import com.system.web_backend_individual1.Services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    public final MessageRepo messageRepo;

    @Override
    public String save_message(MessagePojo messagePojo) {
        Message message= new Message();
        message.setName(messagePojo.getName());
        message.setEmail(messagePojo.getEmail());
        message.setNumber(messagePojo.getNumber());
        message.setMsg(messagePojo.getMsg());
        messageRepo.save(message);
        return "created";
    }
}
