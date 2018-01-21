package com.apress.prospring5.ch4;

import java.security.MessageDigest;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements 
      FactoryBean<MessageDigest>, InitializingBean {

    @Setter
    private String algorithmName = "MD5";

    private MessageDigest messageDigest = null;

    public MessageDigest getObject() throws Exception {
       return messageDigest;
    }

    public Class<MessageDigest> getObjectType() {
        return MessageDigest.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }
}
