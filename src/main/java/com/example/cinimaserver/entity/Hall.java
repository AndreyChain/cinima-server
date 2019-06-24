package com.example.cinimaserver.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Hall {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @ManyToMany(mappedBy = "halls")
    private List <Film> films = new ArrayList<>();

    private String numHall;
    private String priceTicket;
    private int numTicket;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getNumHall() {
        return numHall;
    }

    public void setNumHall(String numHall) {
        this.numHall = numHall;
    }

    public String getPriceTicket() {
        return priceTicket;
    }

    public int getNumTicket() {
        return numTicket;
    }
    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public void setPriceTicket(String priceTicket) {
        this.priceTicket = priceTicket;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
