package com.apress.prospring5.ch12.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Singers implements Serializable {
    @Getter @Setter private List<Singer> singers;
}
