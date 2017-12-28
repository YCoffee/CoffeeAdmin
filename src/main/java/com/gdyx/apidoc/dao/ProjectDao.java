package com.gdyx.apidoc.dao;

import com.gdyx.apidoc.model.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
@Mapper
public interface ProjectDao {
    void save(Project o);
    void saveOrUpdate(Project o);
    void update(Project o);
    void delete(String id);
    Project findProjectById(String id);
    int count(Map<String,Object> map);
    List<Project> findProjects(Map<String,Object> map);
}
