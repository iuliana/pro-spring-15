package com.apress.prospring5.ch4.custom;

import lombok.Getter;
import lombok.Setter;

public class FullName {
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String toString() {
        return "First name: " + firstName + " - Last name: " + lastName;
    }
}
