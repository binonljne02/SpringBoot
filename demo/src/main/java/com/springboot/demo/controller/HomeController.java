package com.springboot.demo.controller;

import com.springboot.demo.model.Car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private String appName;
    static final String APP_NAME = "appName";
    static final String CARS = "cars";

    @GetMapping("/")
    public String getHome(Model model){
        Car[] collections = {
            new Car(1,"abc","300000"),
            new Car(2,"xyz","40000")
        };

        model.addAttribute(CARS, collections);
        model.addAttribute(APP_NAME, appName);

        return "index";

    }

}
