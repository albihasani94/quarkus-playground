package com.albi.quarkus.playground.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.albi.quarkus.playground.model.Fruit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

    public List<Fruit> findBySeason(String season) {
        return find("season", season).list();
    }

}