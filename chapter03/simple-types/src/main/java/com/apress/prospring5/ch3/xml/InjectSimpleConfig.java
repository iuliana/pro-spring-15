package com.apress.prospring5.ch3.xml;

import lombok.Getter;
import lombok.Setter;

public class InjectSimpleConfig {

	@Getter @Setter private String name = "John Mayer";
	@Getter @Setter private int age = 39;
	@Getter @Setter private float height = 1.92f;
	private boolean programmer = false;
	@Getter @Setter private Long ageInSeconds = 1_241_401_112L;

	public boolean isProgrammer() {
		return programmer;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

}

