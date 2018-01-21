package com.apress.prospring5.ch8.view;

import lombok.Getter;

import java.io.Serializable;

public class SingerSummary implements Serializable {
    @Getter private String firstName;
    @Getter private String lastName;
    @Getter private String latestAlbum;

    public SingerSummary(String firstName, String lastName,
            String latestAlbum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.latestAlbum = latestAlbum;
    }

    public String toString() {
        return "First name: " + firstName + ", Last Name: " + lastName
            + ", Most Recent Album: " + latestAlbum;
    }
}
