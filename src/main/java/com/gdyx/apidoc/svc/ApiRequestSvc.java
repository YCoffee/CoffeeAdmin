package com.gdyx.apidoc.svc;

import com.gdyx.apidoc.model.ApiRequest;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
public interface ApiRequestSvc {
    void save(ApiRequest o);

    void saveOrUpdate(ApiRequest o);

    void update(ApiRequest o);

    void delete(String id);

    ApiRequest findApiRequestById(String id);

    int count(Map<String, Object> map);

    List<ApiRequest> findApiRequests(Map<String, Object> map);

    List<ApiRequest> findApiRequestslinkApi(Map<String, Object> map);
}
