package com.springboot.carstore.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.carstore.model.Car;

public class CarDao extends Dao {

    public CarDao() {
        collections.add(new Car(1, "abc", "100000"));
        collections.add(new Car(2, "xyz", "200000"));

    }

    @Override
    public List getAll() {
        // TODO Auto-generated method stub
        return collections;
    }

    @Override
    public Optional get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Object t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Object t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Object t) {
        // TODO Auto-generated method stub

    }


    
}
