package com.rainbow.nacos.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Service1Application {
    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class,args);
    }

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @GetMapping("/configs")
    public String getConfigs(){
        return getProperty("common.name")
                +" - " + getProperty("common.age")
                +" - " + getProperty("common.birthday")
                +" - " + getProperty("common.fullname");
    }

    public String getProperty(String key){
        return applicationContext.getEnvironment().getProperty(key);
    }
}
