package com.elvis.springapp.coronavirustrackerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaVirusTrackerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoronaVirusTrackerAppApplication.class, args);
    }

}
