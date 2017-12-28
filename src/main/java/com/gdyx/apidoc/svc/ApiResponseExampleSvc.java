package com.gdyx.apidoc.svc;

import com.gdyx.apidoc.model.ApiResponseExample;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
public interface ApiResponseExampleSvc {
    void save(ApiResponseExample o);

    void saveOrUpdate(ApiResponseExample o);

    void update(ApiResponseExample o);

    void delete(String id);

    ApiResponseExample findApiResponseExampleById(String id);

    int count(Map<String, Object> map);

    List<ApiResponseExample> findApiResponseExamples(Map<String, Object> map);

    List<ApiResponseExample> findApiResponseExamplesLinkApi(Map<String, Object> map);
}
