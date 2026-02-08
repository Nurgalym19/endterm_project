package com.example.endtermapi.controller;

import com.example.endtermapi.patterns.AppConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "ENDTERM API WORKS";
    }

    @GetMapping("/api/app-info")
    public String appInfo() {
        return AppConfig.getInstance().getAppName();
    }
}
