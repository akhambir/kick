package ua.goit.controller;

import ua.goit.servlet.Request;
import ua.goit.view.ModelAndView;
public interface Controller {
  ModelAndView handleRequest(Request request);
}
