package com.apress.prospring5.ch9.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

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

    @OneToMany(mappedBy = "singer", cascade=CascadeType.ALL, orphanRemoval=true)
    @Getter @Setter private Set<Album> albums = new HashSet<>();

    public boolean addAbum(Album album) {
        album.setSinger(this);
        return getAlbums().add(album);
    }

    public void removeAlbum(Album album) {
        getAlbums().remove(album);
    }

    @Override
    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
            + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
