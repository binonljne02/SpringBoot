package com.springboot.carstore.controller;

import com.springboot.carstore.repository.CarDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class HomeController {
    @Autowired
    private CarDao carDao;

    @GetMapping
    public String listAll(Model model){
        model.addAttribute("cars", carDao.getAll());
        return "allcars";
    }
}
