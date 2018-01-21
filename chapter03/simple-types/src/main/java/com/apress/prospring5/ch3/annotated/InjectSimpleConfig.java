package com.apress.prospring5.ch3.annotated;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {

	@Getter private String name = "John Mayer";
	@Getter private int age = 39;
	@Getter private float height = 1.92f;

	private boolean programmer = false;

	@Getter private Long ageInSeconds = 1_241_401_112L;

	public boolean isProgrammer() {
		return programmer;
	}

}
