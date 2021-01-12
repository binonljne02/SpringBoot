package com.springboot.carstore.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import com.springboot.carstore.model.Car;

import org.springframework.util.ResourceUtils;

public class CarDao extends Dao<Car> {

    public CarDao(String csvFile) {
        this.readCSV(csvFile);

    }

    @Override   
    public List getAll() {
        return collections;
    }

    @Override
    public Optional get(int id) {
        return collections.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void add(Car car) {
        int id;
        if (collections.isEmpty()) {
            id = 1;
        } else {
            Car lastCar =collections.get(collections.size() - 1);
            id = lastCar.getId() + 1;
        }
        car.setId(id);
        collections.add(car);
    }

    @Override
    public void update(Car car) {
        //TODO
        get(car.getId()).ifPresent(existcar ->{
            ((Car) existcar).setName(car.getName());
            ((Car) existcar).setPrice(car.getPrice());
        });

  }
    @Override
    public void deleteByID(int id) {
        get(id).ifPresent(existcar -> collections.remove(existcar));
    }

    @Override
    public void delete(Car car) {
        // TODO Auto-generated method stub
        deleteByID(car.getId());
    }

    @Override
    public void readCSV(String csvFile) {
        try {
            File file = ResourceUtils.getFile("classpath:static/" + csvFile);
            CsvMapper mapper = new CsvMapper(); 
            CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator('|'); 
            ObjectReader oReader = mapper.readerFor(Car.class).with(schema); 
            Reader reader = new FileReader(file);
            MappingIterator<Car> mi = oReader.readValues(reader); 
            while (mi.hasNext()) {
              Car car = mi.next();
              this.add(car);
            }
          } catch (IOException e) {
            System.out.println(e);   
          }

    }

    @Override
    public List<Car> searchByKeyword(String keyword) {
        return collections
        .stream()
        .filter(car -> car.matchWithKeyword(keyword))
        .collect(Collectors.toList());
    }



}
