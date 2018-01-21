package com.apress.prospring5.ch2.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by iuliana.cosmina on 4/9/17.
 */
public class Contact {

	@Getter @Setter
	private String name;

	@Getter @Setter
	private String phoneNumber;

	@Getter @Setter
	private String email;
}
