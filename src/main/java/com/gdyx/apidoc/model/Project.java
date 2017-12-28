package com.gdyx.apidoc.model;

import java.io.Serializable;

/**
 * Created by mac on 2017/12/2.
 */
public class Project implements Serializable {
    private String id="";
    private String name="";
    private String description="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
