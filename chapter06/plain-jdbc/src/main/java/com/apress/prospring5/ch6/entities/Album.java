package com.apress.prospring5.ch6.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

public class Album implements Serializable {
    @Getter @Setter private Long id;
    @Getter @Setter private Long singerId;
    @Getter @Setter private String title;
    @Getter @Setter private Date releaseDate;

    @Override
    public String toString() {
        return "Album - Id: " + id + ", Singer id: " + singerId
            + ", Title: " + title + ", Release Date: " + releaseDate;
    }
}
