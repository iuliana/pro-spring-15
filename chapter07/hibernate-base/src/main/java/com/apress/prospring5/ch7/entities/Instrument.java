package com.apress.prospring5.ch7.entities;

import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {
	@Setter private String instrumentId;

	@Setter private Set<Singer> singers = new HashSet<>();

	@Id
	@Column(name = "INSTRUMENT_ID")
	public String getInstrumentId() {
		return this.instrumentId;
	}

	@ManyToMany
	@JoinTable(name = "singer_instrument",
			joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
			inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
	public Set<Singer> getSingers() {
		return this.singers;
	}

	@Override
	public String toString() {
		return "Instrument :" + getInstrumentId();
	}
}