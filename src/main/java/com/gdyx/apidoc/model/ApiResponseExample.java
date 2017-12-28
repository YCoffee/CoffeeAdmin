package com.gdyx.apidoc.model;

import java.io.Serializable;

/**
 * Created by mac on 2017/12/2.
 */
public class ApiResponseExample implements Serializable {
    private String id="";
    private String api_id="";
    private String tag="";
    private String content="";

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
