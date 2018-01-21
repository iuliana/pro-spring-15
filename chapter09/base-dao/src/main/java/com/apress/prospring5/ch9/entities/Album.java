package com.apress.prospring5.ch9.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "album")
@NoArgsConstructor
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    @Getter @Setter private Long id;

    @Version
    @Column(name = "VERSION")
    @Getter @Setter private int version;

    @Column
    @Getter @Setter private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    @Getter @Setter private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    @Getter @Setter private Singer singer;

    public Album(String title, Date releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Album - id: %d, Singer id: %d, Title: %s, Release Date: %s",
                id, singer.getId(), title, sdf.format(releaseDate));
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Album album = (Album) o;
        if (title != null ? !title.equals(album.title) : album.title != null)
            return false;
        return releaseDate != null ? releaseDate.equals(album.releaseDate) : album.releaseDate == null;
    }

    @Override public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }
}
