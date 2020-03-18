package com.rainbow.nacos.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Service2Application {

    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class,args);
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
