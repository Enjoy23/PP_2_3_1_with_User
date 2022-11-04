package web.dao;

import web.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getUsers();

    void addNewUser(User user);

    User findUserById(long id);

    void deleteUser(long id);

    void updateUser(User user,long id);
}
