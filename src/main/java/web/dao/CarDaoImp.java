package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{

    @Override
    public List<Car> getCars(int count) {

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Mazda",3,"red"));
        cars.add(new Car("Mercedes",10,"white"));
        cars.add(new Car("BMW",5,"black"));
        cars.add(new Car("Nissan",370,"white"));
        cars.add(new Car("Lada",10,"gray"));

        return cars.stream().limit(count).toList();
    }

}
