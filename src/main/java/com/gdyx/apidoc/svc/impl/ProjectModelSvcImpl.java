package com.gdyx.apidoc.svc.impl;

import com.gdyx.apidoc.dao.ProjectModelDao;
import com.gdyx.apidoc.model.ProjectModel;
import com.gdyx.apidoc.svc.ProjectModelSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mac on 2017/12/2.
 */
@Service
public class ProjectModelSvcImpl implements ProjectModelSvc {
    @Autowired
    ProjectModelDao dao;

    @Override
    public void save(ProjectModel o) {
        o.setId(UUID.randomUUID().toString().trim().toUpperCase());
        dao.save(o);
    }

    @Override
    public void saveOrUpdate(ProjectModel o) {
        dao.saveOrUpdate(o);
    }

    @Override
    public void update(ProjectModel o) {
        dao.update(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public ProjectModel findProjectModelById(String id) {
        return dao.findProjectModelById(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dao.count(map);
    }

    @Override
    public List<ProjectModel> findProjectModels(Map<String, Object> map) {
        return dao.findProjectModels(map);
    }

    @Override
    public List<ProjectModel> findProjectModelslinkProject(Map<String, Object> map) {
        return dao.findProjectModelslinkProject(map);
    }
}
