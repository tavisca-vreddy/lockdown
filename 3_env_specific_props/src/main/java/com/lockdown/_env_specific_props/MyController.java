package com.lockdown._env_specific_props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @Value("${environment}")
    public String env;

    @Value("${localone}")
    public String defaultproperty;

    @GetMapping("/getenv")
    public String get()
    {
        return env+", default:"+defaultproperty;
    }
}
