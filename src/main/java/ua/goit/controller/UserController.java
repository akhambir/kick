package ua.goit.controller;

import org.apache.log4j.Logger;
import ua.goit.servlet.Request;
import ua.goit.view.ModelAndView;

public class UserController implements Controller {
  private static final Logger logger = Logger.getLogger(UserController.class);

  @Override
  public ModelAndView handleRequest(Request request) {
    logger.info("Start execute" + UserController.class.getName());
    return null;
  }
}
