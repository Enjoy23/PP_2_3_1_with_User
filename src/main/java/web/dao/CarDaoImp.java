package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDaoImp implements CarDao {

    @PersistenceContext
    private EntityManager entityManager;
//    @Autowired
//    public CarDaoImp(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public List<Car> getCars() {
        return entityManager.createQuery("FROM Car", Car.class).getResultList();
    }
    @Override
    public void addNewCar(Car car){
        entityManager.persist(car);
    }
    @Override
    public Optional<Car> findCarById(long id) {
        return Optional.ofNullable(entityManager.find(Car.class, id));
    }

    @Override
    public void deleteCar(long id) {
        entityManager.remove(findCarById(id).orElseThrow(() -> new RuntimeException("Car by id = " + id + " not found")));;
    }

    @Override
    public void updateCar(Car car) {
        entityManager.merge(car);
    }

}
