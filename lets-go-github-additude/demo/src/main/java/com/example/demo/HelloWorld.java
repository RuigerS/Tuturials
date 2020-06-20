package com.example.demo;

import net.minidev.json.JSONUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/")
    public String helloWorld() {
        return "HelloWorld";
    }
}
