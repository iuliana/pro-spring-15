package com.apress.prospring5.ch18.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "singer")
@NoArgsConstructor
public class Singer implements Serializable {

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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	@Getter @Setter private Date birthDate;

	public Singer(String firstName, String lastName, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: " +
				new SimpleDateFormat("yyyy-MM-dd").format(birthDate);
	}
}
