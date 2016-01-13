package ua.goit.service;

import ua.goit.model.User;

public interface LoginInService {
  User getUser(String login);
  boolean checkPassword(User user, String Password);
  String generateToken(User user);
  void updateToken(User user);
}
