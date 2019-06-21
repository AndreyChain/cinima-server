package com.example.cinimaserver.controllers;

import com.example.cinimaserver.entity.Film;
import com.example.cinimaserver.entity.OrderClient;
import com.example.cinimaserver.repositories.FilmRepostory;
import com.example.cinimaserver.repositories.HallRepository;
import com.example.cinimaserver.repositories.OrderClientRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderClientController {

    @Autowired
    private OrderClientRepository orderClientRepository;

    @Autowired
    private FilmRepostory filmRepostory;

    @Autowired
    private HallRepository hallRepository;

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String order(Model model,
            @PathVariable("id") Integer id) {
        model.addAttribute("film", filmRepostory.findById(id).get().getName());
        model.addAttribute("halls", filmRepostory.findById(id).get().getHalls());
        //model.addAttribute("hallsData",filmRepostory.findById(id).get().getHalls().get(id).getDateTime());
        return "add_order";
    }


}