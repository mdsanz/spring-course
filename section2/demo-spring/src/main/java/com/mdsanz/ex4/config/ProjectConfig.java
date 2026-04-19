package com.mdsanz.ex4.config;

import com.mdsanz.ex4.beans.Person;
import com.mdsanz.ex4.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.mdsanz.ex4.beans"})
public class ProjectConfig {

    @Bean
    Vehicle vehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        return vehicle;
    }

//    @Bean
//    Person person() {
//        Person person = new Person();
//        person.setName("Lucy");
//        person.setVehicle(vehicle());
//        return person;
//    }

    @Bean
    Person person(Vehicle vehicle) {
        Person person = new Person();
        person.setName("Lucy");
        person.setVehicle(vehicle);
        return person;
    }
}
