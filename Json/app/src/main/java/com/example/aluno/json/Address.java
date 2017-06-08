package com.example.aluno.json;

/**
 * Created by aluno on 07/06/2017.
 */

public class Address {
    private String street;
    private Geo geo;

    public Address(){

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
