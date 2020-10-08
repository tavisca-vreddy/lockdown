package com.lockdown.myConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @Value("${environment}")
    private String env;

    @Value("${message}")
    private String message;

    @GetMapping("/getenv")
    public String get()
    {
        return "Environment:"+env+"\n message:"+message;
    }
}
