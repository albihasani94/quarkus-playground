package com.albi.quarkus.playground.rest;

import com.albi.quarkus.playground.model.Fruit;
import com.albi.quarkus.playground.repository.FruitRepository;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/fruits")
public class FruitResource {

    @Inject
    FruitRepository fruitRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> fruitsBySeason(@QueryParam("season") String season) {
        if (season != null) {
            return fruitRepository.findBySeason(season);
        }
        return fruitRepository.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFruit(Fruit fruit) {
        fruit.id = null;
        fruit.persist();
        return Response.status(Status.CREATED).entity(fruit).build();
    }
    
}