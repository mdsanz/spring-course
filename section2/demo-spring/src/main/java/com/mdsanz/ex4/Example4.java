package com.mdsanz.ex4;

import com.mdsanz.ex4.beans.Car;
import com.mdsanz.ex4.beans.Engine;
import com.mdsanz.ex4.beans.Person;
import com.mdsanz.ex4.beans.Vehicle;
import com.mdsanz.ex4.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example4 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var person = context.getBean(Person.class);
        var veh = context.getBean(Vehicle.class);

        System.out.println("Person name from Spring Context is: " + person.getName());
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());
        System.out.println("Vehicle that Person own is: " + person.getVehicle());

        var car = context.getBean(Car.class);
        var engine = context.getBean(Engine.class);

        System.out.println("Car name from Spring Context is: " + car.getName());
        System.out.println("Engine name from Spring Context is: " + engine.getName());
        System.out.println("Engine that Car own is: " + car.getEngine());
    }
}