package com.apress.prospring5.ch15.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "singer")
@NamedQueries({
        @NamedQuery(name=Singer.FIND_ALL, query="select s from Singer s"),
        @NamedQuery(name=Singer.COUNT_ALL, query="select count(s) from Singer s")
})
@NoArgsConstructor
public class Singer implements Serializable {

    public static final String FIND_ALL = "Singer.findAll";
    public static final String COUNT_ALL = "Singer.countAll";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    @Getter @Setter private Long id;

    @Version
    @Column(name = "VERSION")
    @Getter @Setter private int version;

    @Column(name = "FIRST_NAME")
    @Getter @Setter private String firstName;

    @Column(name = "LAST_NAME")
    @Getter @Setter private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    @Getter @Setter private Date birthDate;

    @Override
    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
            + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
