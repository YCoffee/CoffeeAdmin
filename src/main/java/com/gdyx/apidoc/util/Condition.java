package com.gdyx.apidoc.util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mac on 2017/5/20.
 */

public class Condition {

    private String connector;
    private String column;
    private String operator;
    private String type;
    private Object value;

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) throws Exception {
        List<String> list = Arrays.asList("and,or,order by".split(","));
        if (!list.contains(connector)) {
            throw new Exception("连接符只能为and or");
        }
        this.connector = connector;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) throws Exception {
        List<String> list = Arrays.asList("=,>,<,<>,in,not in,between,like,desc,asc".split(","));
        if (!list.contains(operator)) {
            throw new Exception("操作符只能包含=,>,<,<>,in,not in,between,like,desc,asc");
        }
        this.operator = operator;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) throws Exception {
        List<String> list = Arrays.asList("N,S".split(","));
        if (!list.contains(type)) {
            throw new Exception("条件值的类型只能是N或S");
        }
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
