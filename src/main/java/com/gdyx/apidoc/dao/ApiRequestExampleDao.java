package com.gdyx.apidoc.dao;

import com.gdyx.apidoc.model.ApiRequestExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
@Mapper
public interface ApiRequestExampleDao {
    void save(ApiRequestExample o);

    void saveOrUpdate(ApiRequestExample o);

    void update(ApiRequestExample o);

    void delete(String id);

    ApiRequestExample findApiRequestExampleById(String id);

    int count(Map<String, Object> map);

    List<ApiRequestExample> findApiRequestExamples(Map<String, Object> map);

    List<ApiRequestExample> findApiRequestExamplesLinkApi(Map<String, Object> map);
}
