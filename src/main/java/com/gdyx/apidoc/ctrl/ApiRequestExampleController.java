package com.gdyx.apidoc.ctrl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gdyx.apidoc.model.Api;
import com.gdyx.apidoc.model.ApiRequestExample;
import com.gdyx.apidoc.svc.ApiRequestExampleSvc;
import com.gdyx.apidoc.svc.ApiSvc;
import com.gdyx.apidoc.util.Condition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/12/4.
 */
@RestController("/ApiRequestExampleController")
@RequestMapping("/ApiRequestExample")
public class ApiRequestExampleController extends BaseController {
    @Autowired
    ApiRequestExampleSvc svc;
    @Autowired
    ApiSvc apiSvc;

    @GetMapping("/goApiRequestExample")
    public ModelAndView goApiRequestExample() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ApiRequestExamples");
        return modelAndView;
    }


    @GetMapping
    public String getMsg(@RequestParam int page, @RequestParam int limit, String field, String order) {
        //排序
        String toField = StringUtils.isEmpty(field) ? "id" : field;
        String toOrder = StringUtils.isEmpty(order) ? "asc" : order;
        Map<String, Object> map = new HashMap<>();
        List<Condition> conditions = new ArrayList<>();
        conditions.add(ruleBuild("order by", toField, toOrder, "", "N"));
        map.put("conditions", conditions);
        //分页使用
        PageHelper.startPage(page, limit);
        List<ApiRequestExample> apiRequestExampleList = svc.findApiRequestExamplesLinkApi(map);
        PageInfo pageInfo = new PageInfo(apiRequestExampleList);
        JSONArray returnJSON = new JSONArray();
        apiRequestExampleList.stream().forEach(p -> {
            returnJSON.add(p);
        });
        return commonMsgResp(2000, "获取成功", pageInfo.getTotal(), returnJSON);
    }

    @GetMapping("/goAdd")
    public ModelAndView goAdd() {
        ModelAndView modelAndView = new ModelAndView();
        List<Api> apiList = apiSvc.findApis(new HashMap<>());
        modelAndView.addObject("ApiList", apiList);
        modelAndView.setViewName("ApiRequestExampleAdd");
        return modelAndView;
    }

    @GetMapping("/getEdit")
    public ModelAndView getEdit(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Api> apiList = apiSvc.findApis(new HashMap<>());
        ApiRequestExample apiRequestExample = svc.findApiRequestExampleById(id);
        modelAndView.addObject("ApiRequestExample", apiRequestExample);
        modelAndView.addObject("ApiList", apiList);
        modelAndView.setViewName("ApiRequestExampleEdit");
        return modelAndView;
    }

    @PostMapping("/Save")
    public String Save(@RequestBody String data) {
        if (JSONJudge(data)) {
            ApiRequestExample apiRequestExample = JSONObject.parseObject(data, ApiRequestExample.class);
            svc.save(apiRequestExample);
            return commonResp(2000, "保存成功");
        } else {
            return commonResp(4000, "传入数据不为JSON格式字符串");
        }
    }

    @PostMapping("/Update")
    public String Update(@RequestBody String data) {
        if (JSONJudge(data)) {
            ApiRequestExample apiRequestExample = JSONObject.parseObject(data, ApiRequestExample.class);
            svc.update(apiRequestExample);
            return commonResp(2000, "保存成功");
        } else {
            return commonResp(4000, "传入数据不为JSON格式字符串");
        }
    }

    @PostMapping("/Delete")
    public String Delete(@RequestBody String data) {
        if (JSONJudge(data)) {
            String id = JSONObject.parseObject(data).getString("id");
            svc.delete(id);
            return commonResp(2000, "删除成功");
        } else {
            return commonResp(4000, "传入数据不为JSON格式字符串");
        }
    }
}
