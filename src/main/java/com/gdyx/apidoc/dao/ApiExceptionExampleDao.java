package com.gdyx.apidoc.dao;

import com.gdyx.apidoc.model.ApiExceptionExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
@Mapper
public interface ApiExceptionExampleDao {
    void save(ApiExceptionExample o);

    void saveOrUpdate(ApiExceptionExample o);

    void update(ApiExceptionExample o);

    void delete(String id);

    ApiExceptionExample findApiExceptionExampleById(String id);

    int count(Map<String, Object> map);

    List<ApiExceptionExample> findApiExceptionExamples(Map<String, Object> map);

    List<ApiExceptionExample> findApiExceptionExamplesLinkApi(Map<String, Object> map);
}
