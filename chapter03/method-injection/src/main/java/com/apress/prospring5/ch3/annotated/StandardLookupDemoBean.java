package com.apress.prospring5.ch3.annotated;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standardLookupBean")
public class StandardLookupDemoBean implements DemoBean {

	@Getter
	private Singer mySinger;

	@Autowired
	@Qualifier("singer")
	public void setMySinger(Singer mySinger) {
		this.mySinger = mySinger;
	}

	@Override
	public void doSomething() {
		mySinger.sing();
	}
}
