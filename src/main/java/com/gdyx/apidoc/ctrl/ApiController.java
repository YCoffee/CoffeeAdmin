package com.gdyx.apidoc.ctrl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gdyx.apidoc.model.Api;
import com.gdyx.apidoc.model.Project;
import com.gdyx.apidoc.model.ProjectModel;
import com.gdyx.apidoc.svc.ApiSvc;
import com.gdyx.apidoc.svc.ProjectModelSvc;
import com.gdyx.apidoc.svc.ProjectSvc;
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
 * Created by mac on 2017/11/30.
 */
@RestController
@RequestMapping("/Api")
public class ApiController extends BaseController {
    @Autowired
    ApiSvc svc;
    @Autowired
    ProjectSvc projectSvc;
    @Autowired
    ProjectModelSvc projectModelSvc;

    @GetMapping("/goApi")
    public ModelAndView goApi() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Api");
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
        List<Api> apiList = svc.findApisLinkAs(map);
        PageInfo pageInfo = new PageInfo(apiList);
        JSONArray returnJSON = new JSONArray();
        apiList.stream().forEach(p -> {
            returnJSON.add(p);
        });
        return commonMsgResp(2000, "获取成功", pageInfo.getTotal(), returnJSON);
    }

    @GetMapping("/goAdd")
    public ModelAndView goAdd() {
        ModelAndView modelAndView = new ModelAndView();
        List<Project> projectList = projectSvc.findProjects(new HashMap<>());
        List<ProjectModel> projectModelList = projectModelSvc.findProjectModels(new HashMap<>());
        modelAndView.addObject("ProjectList", projectList);
        modelAndView.addObject("ProjectModelList", projectModelList);
        modelAndView.setViewName("ApiAdd");
        return modelAndView;
    }

    @GetMapping("/getEdit")
    public ModelAndView getEdit(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView();
        Api api = svc.findApiById(id);
        List<Project> projectList = projectSvc.findProjects(new HashMap<>());
        List<ProjectModel> projectModelList = projectModelSvc.findProjectModels(new HashMap<>());
        modelAndView.addObject("ProjectList", projectList);
        modelAndView.addObject("ProjectModelList", projectModelList);
        modelAndView.addObject("Api", api);
        modelAndView.setViewName("ApiEdit");
        return modelAndView;
    }

    @PostMapping("/Save")
    public String Save(@RequestBody String data) {
        if (JSONJudge(data)) {
            Api api = JSONObject.parseObject(data, Api.class);
            svc.save(api);
            return commonResp(2000, "保存成功");
        } else {
            return commonResp(4000, "传入数据不为JSON格式字符串");
        }
    }

    @PostMapping("/Update")
    public String Update(@RequestBody String data) {
        if (JSONJudge(data)) {
            Api api = JSONObject.parseObject(data, Api.class);
            svc.update(api);
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
