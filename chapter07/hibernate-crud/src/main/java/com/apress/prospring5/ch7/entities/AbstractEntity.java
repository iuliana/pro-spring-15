package com.apress.prospring5.ch7.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by iuliana.cosmina on 4/23/17.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	@Getter @Setter
	protected Long id;

	@Version
	@Column(name = "VERSION")
	@Getter @Setter
	private int version;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AbstractEntity that = (AbstractEntity) o;
		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
