package ua.goit.controller;

import org.apache.log4j.Logger;
import ua.goit.servlet.Request;
import ua.goit.view.ModelAndView;

public class ErrorController implements Controller {
  private static final Logger logger = Logger.getLogger(ErrorController.class);

  @Override
  public ModelAndView handleRequest(Request request) {
    logger.info("Start execute" + ErrorController.class.getName());
    ModelAndView modelAndView = new ModelAndView("/error.jsp");
    modelAndView.addAttribute("error", request.getParameters().get("error"));
    return modelAndView;
  }
}
