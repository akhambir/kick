package ua.goit.controller;

import org.apache.log4j.Logger;
import ua.goit.dao.CategoryDao;
import ua.goit.dao.ProjectDao;
import ua.goit.model.Category;
import ua.goit.model.Project;
import ua.goit.service.CategoryService;
import ua.goit.service.CategoryServiceImpl;
import ua.goit.service.ProjectService;
import ua.goit.service.ProjectServiceImpl;
import ua.goit.servlet.Request;
import ua.goit.view.ModelAndView;
import java.util.List;

public class CategoryController implements Controller {
  private static final Logger logger = Logger.getLogger(CategoryController.class);
  private final CategoryService categoryService;
  private final ProjectService projectService;

  public CategoryController(CategoryService categoryService, ProjectService projectService) {
    this.categoryService = categoryService;
    this.projectService = projectService;
  }

  @Override
  public ModelAndView handleRequest(Request request) {
    logger.info("Start execute" + CategoryController.class.getName());
    List<Category> categories = categoryService.getAll();
    ModelAndView modelAndView = new ModelAndView("/categories.jsp");
    if (request.getParameters().isEmpty()) {
      modelAndView.addAttribute("categories", categories);
    } else {
      String categoryId = request.getParameters().get("category");
      List<Project> projects = projectService.
              getProjectsByCategoryId(Integer.valueOf(categoryId));
      modelAndView.addAttribute("projects", projects);
    }
    return modelAndView;
  }
}
