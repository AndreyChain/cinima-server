package com.example.cinimaserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Start {
    @RequestMapping("/")
    public String starting(){
        return "starting";
    }

}
