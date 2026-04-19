package com.mdsanz.ex3;

import com.mdsanz.ex3.beans.Vehicle;
import com.mdsanz.ex3.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        veh.sayHello();

        context.close();
    }
}