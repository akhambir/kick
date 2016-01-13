package ua.goit.controller;

import org.apache.log4j.Logger;
import ua.goit.dao.UserDao;
import ua.goit.model.User;
import ua.goit.service.UserService;
import ua.goit.service.UserServiceImpl;
import ua.goit.servlet.Request;
import ua.goit.view.ModelAndView;

public class ActivationController implements Controller {
  private final static Logger logger = Logger.getLogger(ActivationController.class);
  private final UserService userService;

  public ActivationController(UserService userService) {
    this.userService = userService;
  }

  @Override
  public ModelAndView handleRequest(Request request) {
    logger.info("Start execute" + ActivationController.class.getName());
    ModelAndView error = new ModelAndView("/error.jsp");

    if (request.getParameters().get("key").isEmpty()) {
      return error;
    } else {
      String key = request.getParameters().get("key");
      User user = userService.findByActivationKey(key);
      if (user == null) {
        return error;
      } else {
        user.setIsActive(1);
        userService.update(user);
        return new ModelAndView("/success_registration.jsp");
      }
    }
  }
}
