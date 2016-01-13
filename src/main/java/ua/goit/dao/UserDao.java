package ua.goit.dao;

import ua.goit.model.User;

public interface UserDao extends GenericDao<User> {
    User getByLogin(String login);
    User findByToken(String token);
    User findByActivationKey(String key);
}
