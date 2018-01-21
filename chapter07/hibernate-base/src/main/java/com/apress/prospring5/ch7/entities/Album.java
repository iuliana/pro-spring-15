package com.apress.prospring5.ch7.entities;

import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
@Entity
@Table(name = "album")
public class Album implements Serializable {

	@Setter private Long id;
	@Setter private String title;
	@Setter private Date releaseDate;
	@Setter private int version;

	@Setter private Singer singer;

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

	@ManyToOne
	@JoinColumn(name = "SINGER_ID")
	public Singer getSinger() {
		return this.singer;
	}

	@Column
	public String getTitle() {
		return this.title;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RELEASE_DATE")
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	@Override
	public String toString() {
		return "Album - Id: " + id + ", Singer id: " + singer.getId()
				+ ", Title: " + title + ", Release Date: " + releaseDate;
	}
}
