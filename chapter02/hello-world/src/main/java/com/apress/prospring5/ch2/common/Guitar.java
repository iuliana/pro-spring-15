package com.apress.prospring5.ch2.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by iuliana.cosmina on 4/2/17.
 */
public class Guitar {
	@Getter
	@Setter
	private String brand =" Martin";

	public String play(){
		return "G C G C Am D7";
	}

}
