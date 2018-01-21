package com.apress.prospring5.ch3.xml;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleSpel {
    @Getter @Setter private String name;
    @Getter @Setter private int age;
    @Getter @Setter private float height;
    private boolean programmer;
    @Getter @Setter private Long ageInSeconds;

    public boolean isProgrammer() {
        return this.programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public String toString() {
        return "Name: " + name + "\n" 
            + "Age: " + age + "\n"
            + "Age in Seconds: " + ageInSeconds + "\n" 
            + "Height: " + height + "\n" 
            + "Is Programmer?: " + programmer;
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        InjectSimpleSpel simple = (InjectSimpleSpel)ctx.getBean("injectSimpleSpel");
        System.out.println(simple);

        ctx.close();
    }
}
