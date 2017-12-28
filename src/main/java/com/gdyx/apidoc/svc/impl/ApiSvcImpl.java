package com.gdyx.apidoc.svc.impl;

import com.gdyx.apidoc.dao.ApiDao;
import com.gdyx.apidoc.model.Api;
import com.gdyx.apidoc.svc.ApiSvc;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mac on 2017/12/2.
 */
@Service
public class ApiSvcImpl implements ApiSvc {
    @Autowired
    ApiDao dao;

    @Override
    public void save(Api o) {
        o.setId(UUID.randomUUID().toString().toUpperCase().trim());
        dao.save(o);
    }

    @Override
    public void saveOrUpdate(Api o) {
        dao.saveOrUpdate(o);
    }

    @Override
    public void update(Api o) {
        dao.update(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public Api findApiById(String id) {
        return dao.findApiById(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dao.count(map);
    }

    @Override
    public List<Api> findApis(Map<String, Object> map) {
        return dao.findApis(map);
    }

    @Override
    public List<Api> findApisLinkAs(Map<String, Object> map) {
        return dao.findApisLinkAs(map);
    }

}
