package com.aniket.demoapp.controller;

import com.aniket.demoapp.dao.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController("/")
public class HomeController {

    @Autowired
    private RestartEndpoint restartEndpoint;

    @GetMapping("/status")
    public SystemInfo getHealth(){
        System.out.println("********************************");
//C:\Users\royan\IdeaProjects>java  -Dloader.path=file:./demoapi-final-plain.jar -jar demoapi-0.0.1-SNAPSHOT.jar
        System.out.println("********************************");
        return  SystemInfo.builder()
                .localDate(LocalDate.now())
                .status("UP")
                .build();
    }

    @PostMapping("/publish")
    public SystemInfo publishChange(){

        restartEndpoint.restart();
        return  SystemInfo.builder()
                .localDate(LocalDate.now())
                .status("Success")
                .build();
    }
}
