package com.apress.prospring5.ch6.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Singer implements Serializable {

	@Getter @Setter private Long id;
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@Getter @Setter private Date birthDate;
	@Getter @Setter private List<Album> albums;

	public boolean addAbum(Album album) {
		if (albums == null) {
			albums = new ArrayList<>();
			albums.add(album);
			return true;
		} else {
			if (albums.contains(album)) {
				return false;
			}
		}
		albums.add(album);
		return true;
	}

	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: " + birthDate;
	}
}
