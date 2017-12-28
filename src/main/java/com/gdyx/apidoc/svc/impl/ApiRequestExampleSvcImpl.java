package com.gdyx.apidoc.svc.impl;

import com.gdyx.apidoc.dao.ApiRequestExampleDao;
import com.gdyx.apidoc.model.ApiRequestExample;
import com.gdyx.apidoc.svc.ApiRequestExampleSvc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mac on 2017/12/2.
 */
@Service
public class ApiRequestExampleSvcImpl implements ApiRequestExampleSvc {
    @Autowired
    ApiRequestExampleDao dao;

    @Override
    public void save(ApiRequestExample o) {
        o.setId(UUID.randomUUID().toString().toUpperCase().trim());
        dao.save(o);
    }

    @Override
    public void saveOrUpdate(ApiRequestExample o) {
        dao.saveOrUpdate(o);
    }

    @Override
    public void update(ApiRequestExample o) {
        dao.update(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public ApiRequestExample findApiRequestExampleById(String id) {
        return dao.findApiRequestExampleById(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dao.count(map);
    }

    @Override
    public List<ApiRequestExample> findApiRequestExamples(Map<String, Object> map) {
        return dao.findApiRequestExamples(map);
    }

    @Override
    public List<ApiRequestExample> findApiRequestExamplesLinkApi(Map<String, Object> map) {
        return dao.findApiRequestExamplesLinkApi(map);
    }
}
