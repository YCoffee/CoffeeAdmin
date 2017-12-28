package com.gdyx.apidoc.svc.impl;

import com.gdyx.apidoc.dao.ApiResponseDao;
import com.gdyx.apidoc.model.ApiResponse;
import com.gdyx.apidoc.svc.ApiResponseSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mac on 2017/12/2.
 */
@Service
public class ApiResponseSvcImpl implements ApiResponseSvc {

    @Autowired
    ApiResponseDao dao;

    @Override
    public void save(ApiResponse o) {
        o.setId(UUID.randomUUID().toString().trim().toUpperCase());
        dao.save(o);
    }

    @Override
    public void saveOrUpdate(ApiResponse o) {
        dao.saveOrUpdate(o);
    }

    @Override
    public void update(ApiResponse o) {
        dao.update(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public ApiResponse findApiResponseById(String id) {
        return dao.findApiResponseById(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dao.count(map);
    }

    @Override
    public List<ApiResponse> findApiResponses(Map<String, Object> map) {
        return dao.findApiResponses(map);
    }

    @Override
    public List<ApiResponse> findApiResponseslinkApi(Map<String, Object> map) {
        return dao.findApiResponseslinkApi(map);
    }
}
