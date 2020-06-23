package com.albi.quarkus.playground.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Fruit extends PanacheEntity {

    public String name;
    public String season;

}