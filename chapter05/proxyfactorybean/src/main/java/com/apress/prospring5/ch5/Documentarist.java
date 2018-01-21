package com.apress.prospring5.ch5;

import lombok.Setter;

public class Documentarist {

	@Setter protected GrammyGuitarist guitarist;

	public void execute() {
		guitarist.sing();
		guitarist.talk();
	}

}
