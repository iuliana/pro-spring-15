package com.apress.prospring5.ch3.annotated;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by iuliana.cosmina on 2/15/17.
 */
@Component
public class Inspiration {

	@Getter @Setter
	private String lyric = "I can keep the door cracked open, to let light through";

	public Inspiration(@Value("For all my running, I can understand") String lyric) {
		this.lyric = lyric;
	}

}
