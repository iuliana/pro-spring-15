package com.apress.prospring5.ch10;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import java.net.URL;
import java.text.SimpleDateFormat;

@NoArgsConstructor
public class Singer {
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private DateTime birthDate;
    @Getter @Setter private URL personalSite;

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("{First name: %s, Last name: %s, Birthday: %s, Site: %s}",
                 firstName, lastName, sdf.format(birthDate.toDate()), personalSite);
    }
}
