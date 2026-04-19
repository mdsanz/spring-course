package com.mdsanz.ex2;

import com.mdsanz.ex2.beans.Vehicle;
import com.mdsanz.ex2.config.AnotherProjectConfig;
import com.mdsanz.ex2.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class, AnotherProjectConfig.class);

        var veh = context.getBean("audiVehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        var vehicle = (Vehicle) context.getBean("myFavoriteVehicle");
        System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());

        var vehi = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + vehi.getName());

        var helloWorld = context.getBean(String.class);
        System.out.println("String value from Spring Context is: " + helloWorld);
    }
}