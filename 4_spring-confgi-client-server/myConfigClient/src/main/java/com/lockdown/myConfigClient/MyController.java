package com.lockdown.myConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RefreshScope //used for to refresh config server changes(propoerties change at runtime)
// and has one acutator endpoint to refresh this MyController bean dependencies of properties file
//actuator is a dependency  and exposes some endpoints
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
