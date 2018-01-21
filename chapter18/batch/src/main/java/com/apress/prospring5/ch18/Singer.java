package com.apress.prospring5.ch18;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Singer {
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    //best song :D
    @Getter @Setter private String song;

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName + ", song: " + song;
    }
}
