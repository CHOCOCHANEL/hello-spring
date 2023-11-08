package com.chocochanel.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println("LOGGER : HelloController.hello");
        model.addAttribute("data", "Hello!");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        System.out.println("LOGGER : HelloController.helloMvc ::: name = " + name);
        model.addAttribute("name", name);
        return "hello-template";
    }
}
