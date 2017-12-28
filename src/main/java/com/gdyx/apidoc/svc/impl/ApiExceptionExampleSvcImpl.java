package com.gdyx.apidoc.svc.impl;

import com.gdyx.apidoc.dao.ApiExceptionExampleDao;
import com.gdyx.apidoc.model.ApiExceptionExample;
import com.gdyx.apidoc.svc.ApiExceptionExampleSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mac on 2017/12/2.
 */
@Service
public class ApiExceptionExampleSvcImpl implements ApiExceptionExampleSvc {
    @Autowired
    ApiExceptionExampleDao dao;

    @Override
    public void save(ApiExceptionExample o) {
        o.setId(UUID.randomUUID().toString().toUpperCase().trim());
        dao.save(o);
    }

    @Override
    public void saveOrUpdate(ApiExceptionExample o) {
        dao.saveOrUpdate(o);
    }

    @Override
    public void update(ApiExceptionExample o) {
        dao.update(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public ApiExceptionExample findApiExceptionExampleById(String id) {
        return dao.findApiExceptionExampleById(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dao.count(map);
    }

    @Override
    public List<ApiExceptionExample> findApiExceptionExamples(Map<String, Object> map) {
        return dao.findApiExceptionExamples(map);
    }

    @Override
    public List<ApiExceptionExample> findApiExceptionExamplesLinkApi(Map<String, Object> map) {
        return dao.findApiExceptionExamplesLinkApi(map);
    }
}
