package com.gdyx.apidoc.model;

import java.io.Serializable;

/**
 * Created by mac on 2017/12/2.
 */
public class ProjectModel implements Serializable {
    private String id="";
    private String project_id="";
    private String name="";
    private String parent="";
    private String description="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
