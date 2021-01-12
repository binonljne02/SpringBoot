package com.springboot.carstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Car {
    @JsonIgnore
    private int  id;
    private String name;
    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean matchWithKeyword(String keyword){
        String keywordLowerCase = keyword.toLowerCase();
        return (name.toLowerCase().contains(keywordLowerCase));
    }

    
}
