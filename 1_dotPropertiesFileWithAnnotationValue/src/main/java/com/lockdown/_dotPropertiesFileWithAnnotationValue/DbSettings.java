package com.lockdown._dotPropertiesFileWithAnnotationValue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration //tells spring that  this is a bean
@ConfigurationProperties("db") //used to gruop related props of db as a one instance
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
