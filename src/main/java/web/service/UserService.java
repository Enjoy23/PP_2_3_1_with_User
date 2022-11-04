package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void addNewUser(User user);

    User findUserById(long id);

    @Transactional
    void deleteUser(long id);

    @Transactional
    void updateUser(User user,long id);
}
