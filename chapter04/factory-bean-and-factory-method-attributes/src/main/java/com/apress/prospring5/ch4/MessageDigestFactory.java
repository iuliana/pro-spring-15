package com.apress.prospring5.ch4;

import lombok.Setter;

import java.security.MessageDigest;

public class MessageDigestFactory {
    @Setter private String algorithmName = "MD5";

    public MessageDigest createInstance() throws Exception {
       return MessageDigest.getInstance(algorithmName);
    }
}
