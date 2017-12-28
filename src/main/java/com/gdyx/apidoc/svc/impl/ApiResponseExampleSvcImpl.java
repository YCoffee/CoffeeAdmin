package com.gdyx.apidoc.svc.impl;

import com.gdyx.apidoc.dao.ApiResponseExampleDao;
import com.gdyx.apidoc.model.ApiResponseExample;
import com.gdyx.apidoc.svc.ApiResponseExampleSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
@Service
public class ApiResponseExampleSvcImpl implements ApiResponseExampleSvc {
    @Autowired
    ApiResponseExampleDao dao;

    @Override
    public void save(ApiResponseExample o) {
        dao.save(o);
    }

    @Override
    public void saveOrUpdate(ApiResponseExample o) {
dao.saveOrUpdate(o);
    }

    @Override
    public void update(ApiResponseExample o) {
dao.update(o);
    }

    @Override
    public void delete(String id) {
dao.delete(id);
    }

    @Override
    public ApiResponseExample findApiResponseExampleById(String id) {
        return dao.findApiResponseExampleById(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dao.count(map);
    }

    @Override
    public List<ApiResponseExample> findApiResponseExamples(Map<String, Object> map) {
        return dao.findApiResponseExamples(map);
    }

    @Override
    public List<ApiResponseExample> findApiResponseExamplesLinkApi(Map<String, Object> map) {
        return dao.findApiResponseExamplesLinkApi(map);
    }
}
