package com.tusofia.caloriecalculatorproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CalorieCalculatorProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(CalorieCalculatorProjectApplication.class, args);
    }


}
