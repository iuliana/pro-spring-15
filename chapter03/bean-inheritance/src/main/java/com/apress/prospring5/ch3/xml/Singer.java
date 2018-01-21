package com.apress.prospring5.ch3.xml;

import lombok.Setter;

/**
 * Created by iuliana.cosmina on 2/25/17.
 */
public class Singer {
    @Setter
    private String name;
    @Setter
    private int age;
        
    public String toString() {
        return "\tName: " + name + "\n\t" + "Age: " + age;
    }
}
