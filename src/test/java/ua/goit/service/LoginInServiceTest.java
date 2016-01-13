package ua.goit.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import ua.goit.dao.UserDao;
import ua.goit.model.User;

public class LoginInServiceTest {
  private final String login = "login";
  private final String password = "password";
  private final String wrongPassword = "wrongPassword";

  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Mock
  private UserDao userDao;

  @InjectMocks
  UserServiceImpl userService;

  @Test
  public void userFromDBAndRightPassword_GetUserFromDBAndCheckHisPassword_LoginOk() {
    User user = new User(1, "user", login, password, null, null);
    when(userDao.getByLogin(anyString())).thenReturn(user);
    LoginInService loginInService = new LoginInServiceImpl(userService);
    User userFromLoginService = loginInService.getUser(login);
    boolean isRightPass = loginInService.checkPassword(userFromLoginService, password);
    Assert.assertTrue(isRightPass);
    verify(userDao).getByLogin(anyString());
  }

  @Test
  public void userFromDBAndWrongPassword_GetUserFromDBAndCheckHisPassword_LoginNotOK() {
    User user = new User(1, "user", login, password, null, null);
    when(userDao.getByLogin(anyString())).thenReturn(user);
    LoginInService loginInService = new LoginInServiceImpl(userService);
    User userFromLoginService = loginInService.getUser(login);
    boolean isRightPass = loginInService.checkPassword(userFromLoginService, wrongPassword);
    Assert.assertFalse(isRightPass);
  }
}
