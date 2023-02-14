package com.system.web_backend_individual1.Pojo;

import com.system.web_backend_individual1.Entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessagePojo {
    private String id;
    private String name;
    private String email;
    private String number;
    private String msg;

    public MessagePojo(Message message){
        this.name=message.getName();
        this.email=message.getEmail();
        this.number=message.getNumber();
        this.msg=message.getMsg();
    }

}
