package com.gdyx.apidoc.dao;

import com.gdyx.apidoc.model.Api;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
@Mapper
public interface ApiDao {
    void save(Api o);

    void saveOrUpdate(Api o);

    void update(Api o);

    void delete(String id);

    Api findApiById(String id);

    int count(Map<String, Object> map);

    List<Api> findApis(Map<String, Object> map);

    List<Api> findApisLinkAs(Map<String, Object> map);
}
