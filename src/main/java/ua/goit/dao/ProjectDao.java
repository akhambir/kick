package ua.goit.dao;

import ua.goit.model.Project;

import java.util.List;

public interface ProjectDao extends GenericDao<Project> {
    List<Project> getProjectsByCategoryId(Integer categoryId);
}
