package com.gdyx.apidoc.model;

import java.io.Serializable;

/**
 * Created by mac on 2017/12/2.
 */
public class ApiExceptionCode implements Serializable{
    private String id="";
    private String api_id="";
    private String code="";
    private String description="";
    private String solution="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApi_id() {
        return api_id;
    }

    public void setApi_id(String api_id) {
        this.api_id = api_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
