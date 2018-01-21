package com.apress.prospring5.ch7.entities;

import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by iuliana.cosmina on 4/22/17.
 */
@Entity
@Table(name = "singer")
@NamedQueries({
		@NamedQuery(name="Singer.findById",
				query="select distinct s from Singer s " +
						"left join fetch s.albums a " +
						"left join fetch s.instruments i " +
						"where s.id = :id"),
		@NamedQuery(name="Singer.findAllWithAlbum",
				query="select distinct s from Singer s " +
						"left join fetch s.albums a " +
						"left join fetch s.instruments i")
})
public class Singer implements Serializable {

	@Setter private Long id;
	@Setter private String firstName;
	@Setter private String lastName;
	@Setter private Date birthDate;
	@Setter private int version;
	@Setter private Set<Album> albums = new HashSet<>();
	@Setter private Set<Instrument> instruments = new HashSet<>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return version;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	public Date getBirthDate() {
		return birthDate;
	}

	@OneToMany(mappedBy = "singer", cascade=CascadeType.ALL,
			orphanRemoval=true)
	public Set<Album> getAlbums() {
		return albums;
	}


	@ManyToMany
	@JoinTable(name = "singer_instrument",
			joinColumns = @JoinColumn(name = "SINGER_ID"),
			inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public boolean addAbum(Album album) {
		album.setSinger(this);
		return getAlbums().add(album);
	}

	public void removeAlbum(Album album) {
		getAlbums().remove(album);
	}

	public boolean addInstrument(Instrument instrument) {
		return getInstruments().add(instrument);
	}

	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: " + birthDate;
	}
}
