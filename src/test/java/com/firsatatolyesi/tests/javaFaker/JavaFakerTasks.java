package com.firsatatolyesi.tests.javaFaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerTasks {

    @Test
    public void fakerTest(){

        Faker faker = new Faker(new Locale("de"));
        System.out.println("faker.name().nameWithMiddle() = " + faker.name().nameWithMiddle());
        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());

        System.out.println("faker.numerify(\"TR################\") = " + faker.numerify("TR################"));
        System.out.println("faker.letterify(\"????-???-??????\") = " + faker.letterify("????-???-??????"));
        System.out.println("faker.bothify(\"###-???-#?#??##\") = " + faker.bothify("###-???-#?#??##"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        System.out.println("faker.commerce() = " + faker.commerce().productName());
        System.out.println("faker.chuckNorris() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Suavi"));


    }


}
