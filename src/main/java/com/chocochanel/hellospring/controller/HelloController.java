package com.chocochanel.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/hello-api")
    @ResponseBody
    public String helloApi(@RequestParam(value = "apiNm", required = false) String apiNm) {
        System.out.println("LOGGER : HelloController.helloApi ::: apiNm = " + apiNm);
        // test url ::: localhost:8080/hello-api?apiNm=IF-API-026801
        return apiNm;
    }
}
