package com.apress.prospring5.ch16.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
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

	@NotBlank(message = "{validation.firstname.NotBlank.message}")
	@Size(min = 2, max = 60, message = "{validation.firstname.Size.message}")
	@Column(name = "FIRST_NAME")
	@Getter @Setter private String firstName;

	@NotBlank(message = "{validation.lastname.NotBlank.message}")
	@Size(min = 1, max = 40, message = "{validation.lastname.Size.message}")
	@Column(name = "LAST_NAME")
	@Getter @Setter private String lastName;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	@Getter @Setter private Date birthDate;

	@Column(name = "DESCRIPTION")
	@Getter @Setter private String description;

	@Override
	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: " + birthDate
				+ ", Description: " + description;
	}
}
