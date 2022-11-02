package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();

    void addNewCar(Car car);

    Car findCarById(long id);

    @Transactional
    void deleteCar(long id);

    @Transactional
    void updateCar(Car car);
}
