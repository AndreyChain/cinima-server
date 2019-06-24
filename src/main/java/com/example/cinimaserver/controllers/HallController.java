package com.example.cinimaserver.controllers;

import com.example.cinimaserver.entity.Film;
import com.example.cinimaserver.entity.Hall;
import com.example.cinimaserver.repositories.FilmRepostory;
import com.example.cinimaserver.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HallController {
    @Autowired
    private HallRepository hallRepository;
    @Autowired
    private FilmRepostory filmRepostory;

    @RequestMapping(value = "/hall/add", method = RequestMethod.GET)
    public String showHall(Model model) {
        model.addAttribute("films", filmRepostory.findAll());
        model.addAttribute("hall", new Hall());
        return "add_hall";
    }

    @RequestMapping(value = "/hall/add", method = RequestMethod.POST)
    public String submitHall(@ModelAttribute Hall hall, Model model,
                             @RequestParam(name = "filmId") String filmId) {
        Film film = filmRepostory.findById(Integer.valueOf(filmId)).get();
        updateHall(hall, film);
        hallRepository.save(hall);

        model.addAttribute("addHall", hall.getNumHall());
        model.addAttribute("films", filmRepostory.findAll());
        model.addAttribute("hall", new Hall());
        return "add_hall";
    }

    private void updateHall(Hall newHall, Film film) {

        newHall.getFilms().add(film);

        film.getHalls().add(newHall);
    }
}

