package com.example.cinimaserver.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Film {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String name;
    private String filmDescription;

   @ManyToOne
   @JoinColumn(name = "order_id")
   private OrderClient order_client;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "film_hall",
    joinColumns = @JoinColumn(name = "film_id"),
    inverseJoinColumns = @JoinColumn(name = "hall_id"))
    private List<Hall> halls = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public OrderClient getOrder_client() {
        return order_client;
    }

    public void setOrder_client(OrderClient order_client) {
        this.order_client = order_client;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

}

