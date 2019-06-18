package com.example.cinimaserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/admin")
    public String index(){
        return "index";
    }
}
