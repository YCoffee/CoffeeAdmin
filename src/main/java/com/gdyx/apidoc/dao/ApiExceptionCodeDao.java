package com.gdyx.apidoc.dao;

import com.gdyx.apidoc.model.ApiExceptionCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/2.
 */
@Mapper
public interface ApiExceptionCodeDao {
    void save(ApiExceptionCode o);

    void saveOrUpdate(ApiExceptionCode o);

    void update(ApiExceptionCode o);

    void delete(String id);

    ApiExceptionCode findApiExceptionCodeById(String id);

    int count(Map<String, Object> map);

    List<ApiExceptionCode> findApiExceptionCodes(Map<String, Object> map);

    List<ApiExceptionCode> findApiExceptionCodesLinkApi(Map<String, Object> map);
}
