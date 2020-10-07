package com.lockdown._dotYAMLFileWithAnnotationValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Value("${mymessage.greetings}")//to access directly key
    private String greetings;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/getProperties")
    public List<String> get()
    {
        ArrayList<String> list=new ArrayList<>();
        list.add(greetings);
        list.add(dbSettings.getConnectionstring());
        list.add(dbSettings.getUsername());
        list.add(dbSettings.getPassword());
        return list;
    }
}
