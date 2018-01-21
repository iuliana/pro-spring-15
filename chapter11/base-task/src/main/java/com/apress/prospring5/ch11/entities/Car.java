package com.apress.prospring5.ch11.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;

@Entity
@Table(name="car")
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    @Getter @Setter private Long id;

    @Column(name="LICENSE_PLATE")
    @Getter @Setter private String licensePlate;

    @Column(name="MANUFACTURER")
    @Getter @Setter private String manufacturer;

    @Column(name="MANUFACTURE_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Getter @Setter private DateTime manufactureDate;

    @Column(name="AGE")
    @Getter @Setter private int age;

    @Version
    @Getter @Setter private int version;

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("{License: %s, Manufacturer: %s, Manufacture Date: %s, Age: %d}",
                licensePlate, manufacturer, sdf.format(manufactureDate.toDate()), age);
    }
}
