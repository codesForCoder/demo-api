package com.aniket.demoapi.controller;

import com.aniket.demoapi.dao.SystemInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController("/")
public class HomeController {

    @GetMapping("/status")
    public SystemInfo getHealth(){
        return  SystemInfo.builder()
                .localDate(LocalDate.now())
                .status("UP")
                .build();
    }
}
