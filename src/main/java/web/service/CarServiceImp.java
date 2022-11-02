package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService {
    private final CarDao carDao;

    @Autowired
    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars() {
        return carDao.getCars();
    }
    @Transactional
    @Override
    public void addNewCar(Car car) {
        carDao.addNewCar(car);
    }

    @Override
    public Car findCarById(long id) {
        Optional<Car> user = carDao.findCarById(id);
        return user.orElseThrow(() -> new RuntimeException("Car by id = " + id + " not found"));
    }

    @Transactional
    @Override
    public void deleteCar(long id) {
        carDao.deleteCar(id);
    }

    @Transactional
    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }
}
