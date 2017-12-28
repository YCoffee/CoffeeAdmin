package com.gdyx.apidoc.ctrl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.gdyx.apidoc.util.Condition;

/**
 * Created by Y_Coffee on 2017/12/5.
 */
public class BaseController {

    /**
     * JSON字符串格式判断
     *
     * @param JSONString
     * @return true And false
     */
    public boolean JSONJudge(String JSONString) {
        try {
            JSONObject.parseObject(JSONString);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    /**
     * 动态SQL
     *
     * @param connnctor
     * @param column
     * @param operator
     * @param value
     * @param type
     * @return
     */
    public static Condition ruleBuild(String connnctor, String column, String operator, Object value, String type) {
        Condition condition = new Condition();
        try {
            condition.setConnector(connnctor);
            condition.setColumn(column);
            condition.setOperator(operator);
            condition.setType(type);
            condition.setValue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return condition;
    }

    public String commonResp(int c, String m, JSONArray a) {
        JSONObject objResp = new JSONObject();
        objResp.put("respCode", c);
        objResp.put("respMsg", m);
        objResp.put("data", a);
        System.out.println("响应数据:" + objResp.toString());
        return objResp.toString();
    }

    public String commonResp(int c, String m, JSONObject o) {
        JSONArray array = new JSONArray();
        array.add(o);
        return commonResp(c, m, array);
    }

    public String commonResp(int c, String m) {
        return commonResp(c, m, new JSONArray());
    }

    public String commonMsgResp(int c, String m, long t, JSONArray a) {
        JSONObject objResp = new JSONObject();
        objResp.put("respCode", c);
        objResp.put("respMsg", m);
        objResp.put("total", t);
        objResp.put("data", a);
        System.out.println("响应数据:" + objResp.toString());
        return objResp.toString();
    }
}
