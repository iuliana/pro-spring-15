package com.apress.prospring5.ch3;

import lombok.Setter;

public class SetterInjection {

	@Setter
	private Dependency dependency;

	@Override
	public String toString() {
		return dependency.toString();
	}
}
