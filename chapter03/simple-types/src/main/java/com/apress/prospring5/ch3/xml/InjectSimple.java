package com.apress.prospring5.ch3.xml;

import lombok.Setter;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {

    @Setter private String name;
    @Setter private int age;
    @Setter private float height;
    @Setter private boolean programmer;
    @Setter private Long ageInSeconds;

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-simple-xml.xml");
        ctx.refresh();

        InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
        System.out.println(simple);

        ctx.close();
    }

    public String toString() {
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Age in Seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }
}
