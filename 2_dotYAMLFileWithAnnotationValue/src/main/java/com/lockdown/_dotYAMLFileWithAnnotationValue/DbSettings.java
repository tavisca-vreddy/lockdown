package com.lockdown._dotYAMLFileWithAnnotationValue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("db")
public class DbSettings {
    private String connectionstring;
    private String username;

    public String getConnectionstring() {
        return connectionstring;
    }

    public void setConnectionstring(String connectionstring) {
        this.connectionstring = connectionstring;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
}
