package com.gdyx.apidoc.dao;

import com.gdyx.apidoc.model.ProjectModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
@Mapper
public interface ProjectModelDao {
    void save(ProjectModel o);

    void saveOrUpdate(ProjectModel o);

    void update(ProjectModel o);

    void delete(String id);

    ProjectModel findProjectModelById(String id);

    int count(Map<String, Object> map);

    List<ProjectModel> findProjectModels(Map<String, Object> map);

    List<ProjectModel> findProjectModelslinkProject(Map<String, Object> map);
}
