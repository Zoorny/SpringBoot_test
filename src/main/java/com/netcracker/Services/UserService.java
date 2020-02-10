package com.netcracker.Services;

import com.netcracker.DataHandling.DAO;
import com.netcracker.DataHandling.UserDao;
import com.netcracker.Model.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserService {

    private DAO<User> userDao;

    UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(long id) {
        Optional<User> user = userDao.get(id);

        return user.orElseGet(
                () -> new User("non-existing user", "no-email"));
    }

}
