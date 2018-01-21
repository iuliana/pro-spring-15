package com.apress.prospring5.ch5;

import lombok.Getter;

public class UserInfo {
    @Getter private String userName;
    @Getter private String password;

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
