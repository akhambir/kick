package ua.goit.controller;

import org.apache.log4j.Logger;
import ua.goit.servlet.Request;
import ua.goit.view.ModelAndView;

public class ProjectController implements Controller {
  private static final Logger logger = Logger.getLogger(ProjectController.class);

  @Override
  public ModelAndView handleRequest(Request request) {
    logger.info("Start execute" + ProjectController.class.getName());

    return null;
  }

}
