package com.springboot.carstore.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

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
        // TODO Auto-generated method stub
        return collections;
    }

    @Override
    public Optional get(int id) {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Car car) {
        // TODO Auto-generated method stub

    }

    @Override
    public void readCSV(String csvFile) {
        try {
            File file = ResourceUtils.getFile("classpath:static/" + csvFile);
            CsvMapper mapper = new CsvMapper(); // dùng để ánh xạ từng cột trong csv vời từng trường trong POJO
            CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator('|'); // dòng đều tiên được
                                                                                              // tách ra để làm
                                                                                              // header.
                                                                                              // withColumSeparator
                                                                                              // trong csv dùng | để
                                                                                              // phân tách các phần
            ObjectReader oReader = mapper.readerFor(Car.class).with(schema); // cấu hình file csv với kiểu Car
            Reader reader = new FileReader(file);

            MappingIterator<Car> mi = oReader.readValues(reader); // Iterator đọc từng dòng trong file
            while (mi.hasNext()) {
                Car car = mi.next();
                this.add(car);
            }
        } catch (IOException e) {
            System.out.print(e);
        }

    }



}
