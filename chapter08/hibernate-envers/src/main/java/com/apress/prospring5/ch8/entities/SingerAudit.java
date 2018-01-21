package com.apress.prospring5.ch8.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "singer_audit")
@Audited
@EntityListeners(AuditingEntityListener.class)
public class SingerAudit implements Serializable {

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

	@CreatedDate
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@Setter private Date createdDate;

	@CreatedBy
	@Column(name = "CREATED_BY")
	@Setter private String createdBy;

	@LastModifiedBy
	@Column(name = "LAST_MODIFIED_BY")
	@Setter private String lastModifiedBy;

	@LastModifiedDate
	@Column(name = "LAST_MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@Setter private Date lastModifiedDate;


	public Optional<String> getCreatedBy() {
		return Optional.of(createdBy);
	}

	public Optional<Date> getCreatedDate() {
		return Optional.of(createdDate);
	}

	public Optional<String> getLastModifiedBy() {
		return Optional.of(lastModifiedBy);
	}

	public Optional<Date> getLastModifiedDate() {
		return Optional.of(lastModifiedDate);
	}

	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: " + birthDate
				+ ", Created by: " + createdBy + ", Create date: " + createdDate
				+ ", Modified by: " + lastModifiedBy + ", Modified date: "
				+ lastModifiedDate;
	}

}
