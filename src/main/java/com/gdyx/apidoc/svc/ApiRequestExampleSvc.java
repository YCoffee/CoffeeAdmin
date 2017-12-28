package com.gdyx.apidoc.svc;

import com.gdyx.apidoc.model.ApiRequestExample;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
public interface ApiRequestExampleSvc {
    void save(ApiRequestExample o);

    void saveOrUpdate(ApiRequestExample o);

    void update(ApiRequestExample o);

    void delete(String id);

    ApiRequestExample findApiRequestExampleById(String id);

    int count(Map<String, Object> map);

    List<ApiRequestExample> findApiRequestExamples(Map<String, Object> map);

    List<ApiRequestExample> findApiRequestExamplesLinkApi(Map<String, Object> map);
}
