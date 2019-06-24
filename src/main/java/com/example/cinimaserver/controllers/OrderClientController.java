package com.example.cinimaserver.controllers;

import com.example.cinimaserver.entity.Film;
import com.example.cinimaserver.entity.Hall;
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
    private OrderClientRepository clientRepository;

    @Autowired
    private FilmRepostory filmRepostory;

    @Autowired
    private HallRepository hallRepository;

    private int hallId;
    private int filmId;

    private int numTicket;
    private int numTicketOrder;

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String order(Model model,
                        @PathVariable("id") Integer id) {

        model.addAttribute("film", filmRepostory.findById(id).get().getName());
        model.addAttribute("halls", filmRepostory.findById(id).get().getHalls());
        filmId = filmRepostory.findById(id).get().getId();
        return "add_order";
    }

    @RequestMapping(value = "/order2/{id}", method = RequestMethod.GET)
    public String order2( Model model,
                          @PathVariable ("id") Integer id) {
        model.addAttribute("nameFilm", filmRepostory.findById(filmId).get().getName());
        model.addAttribute("hall2Id", hallRepository.findById(id).get().getDateTime());
        model.addAttribute("order", new OrderClient());
        hallId = hallRepository.findById(id).get().getId();
        return "add_order2";
    }

    @RequestMapping(value = "/order2/add", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute OrderClient order, Hall hallNew, Model model){

        Hall hall = hallRepository.findById(hallId).get();
        Film film = filmRepostory.findById(filmId).get();
        updateOrder(order, film, hall);
        clientRepository.save(order);



        numTicket = hallRepository.findById(hallId).get().getNumTicket();
        numTicketOrder = clientRepository.findById(order.getId()).get().getNumTicket();

        if(numTicket>=numTicketOrder){
          int numTicketSum =  numTicket - numTicketOrder;
          hallRepository.findById(hallId).get().setNumTicket(numTicketSum);
          hallRepository.save(hallNew);
        } else {
            model.addAttribute("noTicket", hallRepository.findById(hallId).get().getNumTicket());
        }


        model.addAttribute("nameClient", clientRepository.findById(order.getId())
                .get().getNameClient());
        model.addAttribute("addHall", clientRepository.findById(order.getId()).get()
                .getHall().getPriceTicket());
        model.addAttribute("addOrder", clientRepository.findById(order.getId()).get()
                .getNumTicket());
        model.addAttribute("addFilm", filmRepostory.findById(filmId).get().getName());
        return "order_show";
    }

    public void updateOrder(OrderClient newOrder, Film film, Hall hall){
        newOrder.setHall(hall);
        newOrder.getFilms().add(film);

        film.setOrder_client(newOrder);
    }
}



