package com.apress.prospring5.ch8.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;

@Entity
@Table(name = "singer")
@NamedQueries({
        @NamedQuery(name=Singer.FIND_ALL, query="select s from Singer s"),
        @NamedQuery(name=Singer.FIND_SINGER_BY_ID,
                query="select distinct s from Singer s " +
                        "left join fetch s.albums a " +
                        "left join fetch s.instruments i " +
                        "where s.id = :id"),
        @NamedQuery(name=Singer.FIND_ALL_WITH_ALBUM,
                query="select distinct s from Singer s " +
                        "left join fetch s.albums a " +
                        "left join fetch s.instruments i")
})
@SqlResultSetMapping(
     name="singerResult",
     entities=@EntityResult(entityClass=Singer.class)
)
@NoArgsConstructor
public class Singer implements Serializable {

    public static final String FIND_ALL = "Singer.findAll";
    public static final String FIND_SINGER_BY_ID = "Singer.findById";
    public static final String FIND_ALL_WITH_ALBUM = "Singer.findAllWithAlbum";

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

    @ManyToMany
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "SINGER_ID"),
            inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    @Getter @Setter private Set<Instrument> instruments = new HashSet<>();

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
