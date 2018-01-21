package com.apress.prospring5.ch14;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

@NoArgsConstructor
public class Singer {
    @Getter @Setter private Long id;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private DateTime birthDate;
    @Getter @Setter private String ageCategory;

    @Override
    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate
                + ", Age category: " + ageCategory;
    }
}
