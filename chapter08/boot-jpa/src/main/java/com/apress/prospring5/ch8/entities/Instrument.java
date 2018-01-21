package com.apress.prospring5.ch8.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {
    @Id
    @Column(name = "INSTRUMENT_ID")
    @Getter @Setter private String instrumentId;

    @ManyToMany
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
    @Getter @Setter private Set<Singer> singers = new HashSet<>();

    @Override
    public String toString() {
        return "Instrument :" + getInstrumentId();
    }
}