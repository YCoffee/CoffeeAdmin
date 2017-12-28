package com.gdyx.apidoc.svc;

import com.gdyx.apidoc.model.ApiExceptionCode;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
public interface ApiExceptionCodeSvc {
    void save(ApiExceptionCode o);

    void saveOrUpdate(ApiExceptionCode o);

    void update(ApiExceptionCode o);

    void delete(String id);

    ApiExceptionCode findApiExceptionCodeById(String id);

    int count(Map<String, Object> map);

    List<ApiExceptionCode> findApiExceptionCodes(Map<String, Object> map);

    List<ApiExceptionCode> findApiExceptionCodesLinkApi(Map<String, Object> map);
}
