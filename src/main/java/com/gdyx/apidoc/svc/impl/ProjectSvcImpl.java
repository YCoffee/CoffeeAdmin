package com.gdyx.apidoc.svc.impl;

import com.gdyx.apidoc.dao.ProjectDao;
import com.gdyx.apidoc.model.Project;
import com.gdyx.apidoc.svc.ProjectSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mac on 2017/12/2.
 */
@Service
public class ProjectSvcImpl implements ProjectSvc {
    @Autowired
    ProjectDao dao;

    @Override
    public void save(Project o) {
        o.setId(UUID.randomUUID().toString().toUpperCase().trim());
        dao.save(o);
    }

    @Override
    public void saveOrUpdate(Project o) {
        dao.saveOrUpdate(o);
    }

    @Override
    public void update(Project o) {
        dao.update(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public Project findProjectById(String id) {
        return dao.findProjectById(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dao.count(map);
    }

    @Override
    public List<Project> findProjects(Map<String, Object> map) {
        return dao.findProjects(map);
    }
}
