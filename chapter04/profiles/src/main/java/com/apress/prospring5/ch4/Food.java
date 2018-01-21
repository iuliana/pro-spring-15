package com.apress.prospring5.ch4;

import lombok.Getter;
import lombok.Setter;

public class Food {
    @Getter @Setter private String name;

    public Food() {
    }

    public Food(String name) {
        this.name = name;
    }
}
