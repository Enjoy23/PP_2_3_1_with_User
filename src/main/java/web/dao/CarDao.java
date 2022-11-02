package web.dao;

import web.model.Car;
import java.util.List;
import java.util.Optional;

public interface CarDao {
    List<Car> getCars();

    void addNewCar(Car car);

    Optional<Car> findCarById(long id);

    void deleteCar(long id);

    void updateCar(Car car);
}
