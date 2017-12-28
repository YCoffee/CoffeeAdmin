package com.gdyx.apidoc.svc.impl;

import com.gdyx.apidoc.dao.ApiExceptionCodeDao;
import com.gdyx.apidoc.model.ApiExceptionCode;
import com.gdyx.apidoc.svc.ApiExceptionCodeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mac on 2017/12/2.
 */
@Service
public class ApiExceptionCodeSvcImpl implements ApiExceptionCodeSvc {
    @Autowired
    ApiExceptionCodeDao dao;

    @Override
    public void save(ApiExceptionCode o) {
        o.setId(UUID.randomUUID().toString().trim().toUpperCase());
        dao.save(o);
    }

    @Override
    public void saveOrUpdate(ApiExceptionCode o) {
        dao.saveOrUpdate(o);
    }

    @Override
    public void update(ApiExceptionCode o) {
        dao.update(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public ApiExceptionCode findApiExceptionCodeById(String id) {
        return dao.findApiExceptionCodeById(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dao.count(map);
    }

    @Override
    public List<ApiExceptionCode> findApiExceptionCodes(Map<String, Object> map) {
        return dao.findApiExceptionCodes(map);
    }

    @Override
    public List<ApiExceptionCode> findApiExceptionCodesLinkApi(Map<String, Object> map) {
        return dao.findApiExceptionCodesLinkApi(map);
    }
}
