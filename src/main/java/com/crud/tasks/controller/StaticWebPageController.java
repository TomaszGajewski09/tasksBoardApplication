package com.crud.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/")
public class StaticWebPageController {

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("variable", "My Thymeleaf variable");
        model.put("comp1", 2);
        model.put("comp2", 2);
        model.put("comp3", 2);

        return "index";
    }
}
