package com.gdyx.apidoc.svc;

import com.gdyx.apidoc.model.Project;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
public interface ProjectSvc {
    void save(Project o);
    void saveOrUpdate(Project o);
    void update(Project o);
    void delete(String id);
    Project findProjectById(String id);
    int count(Map<String,Object> map);
    List<Project> findProjects(Map<String,Object> map);
}
