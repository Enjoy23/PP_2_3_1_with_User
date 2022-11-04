package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("FROM User ", User.class).getResultList();
    }
    @Override
    public void addNewUser(User user){
        entityManager.persist(user);
    }
    @Override
    public User findUserById(long id) {
        return (entityManager.find(User.class, id));
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(findUserById(id));
    }

    @Override
    public void updateUser(User userNew,long id) {
        User user = findUserById(id);
        user.setName(userNew.getName());
        user.setSurname(userNew.getSurname());
        user.setAge(userNew.getAge());
        entityManager.merge(user);
    }

}
