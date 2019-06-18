package com.example.cinimaserver.controllers;

import com.example.cinimaserver.entity.Film;
import com.example.cinimaserver.repositories.FilmRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

    @Controller
    public class FilmGetController {

    @Autowired
    private FilmRepostory filmRepostory;

    @RequestMapping(value = "/film/get", method = RequestMethod.GET)
    public String showFilm (Model model){
        model.addAttribute("films", filmRepostory.findAll());
        return "get_film";
    }

    }
