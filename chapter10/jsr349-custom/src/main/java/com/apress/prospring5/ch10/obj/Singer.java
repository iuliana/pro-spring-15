package com.apress.prospring5.ch10.obj;

import com.apress.prospring5.ch10.CheckCountrySinger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@CheckCountrySinger
@NoArgsConstructor
public class Singer {

	@NotNull
	@Size(min = 2, max = 60)
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@NotNull @Getter @Setter private Genre genre;
	@Getter @Setter private Gender gender;

	public boolean isCountrySinger() {
		return genre == Genre.COUNTRY;
	}
}
