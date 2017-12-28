package com.gdyx.apidoc.svc.impl;

import com.gdyx.apidoc.dao.ApiRequestDao;
import com.gdyx.apidoc.model.ApiRequest;
import com.gdyx.apidoc.svc.ApiRequestSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mac on 2017/12/2.
 */
@Service
public class ApiRequestSvcImpl implements ApiRequestSvc {
    @Autowired
    ApiRequestDao dao;

    @Override
    public void save(ApiRequest o) {
        o.setId(UUID.randomUUID().toString().trim().toUpperCase());
        dao.save(o);
    }

    @Override
    public void saveOrUpdate(ApiRequest o) {
        dao.saveOrUpdate(o);
    }

    @Override
    public void update(ApiRequest o) {
        dao.update(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public ApiRequest findApiRequestById(String id) {
        return dao.findApiRequestById(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dao.count(map);
    }

    @Override
    public List<ApiRequest> findApiRequests(Map<String, Object> map) {
        return dao.findApiRequests(map);
    }

    @Override
    public List<ApiRequest> findApiRequestslinkApi(Map<String, Object> map) {
        return dao.findApiRequestslinkApi(map);
    }
}
