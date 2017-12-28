package com.gdyx.apidoc.ctrl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gdyx.apidoc.model.Project;
import com.gdyx.apidoc.model.ProjectModel;
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
 * Created by mac on 2017/12/4.
 */
@RestController("ProjectModelController")
@RequestMapping("ProjectModel")
public class ProjectModelController extends BaseController {
    @Autowired
    ProjectModelSvc svc;
    @Autowired
    ProjectSvc projectSvc;

    @GetMapping("/goProjectModel")
    public ModelAndView goProjectModel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProjectModels");
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
        List<ProjectModel> projectModelList = svc.findProjectModelslinkProject(map);
        List<ProjectModel> det = new ArrayList<>();
        DoRootProjectModel(projectModelList, det);
        PageInfo pageInfo = new PageInfo(projectModelList);
        JSONArray returnJSON = new JSONArray();
        det.stream().forEach(p -> {
            returnJSON.add(p);
        });
        return commonMsgResp(2000, "获取成功", pageInfo.getTotal(), returnJSON);
    }

    @GetMapping("/goAdd")
    public ModelAndView goAdd() {
        ModelAndView modelAndView = new ModelAndView();
        List<ProjectModel> projectModelList = svc.findProjectModels(new HashMap<>());
        List<Project> projectList = projectSvc.findProjects(new HashMap<>());
        modelAndView.addObject("ProjectList", projectList);
        modelAndView.addObject("ProjectModelList", projectModelList);
        modelAndView.setViewName("ProjectModelAdd");
        return modelAndView;
    }

    @GetMapping("/getEdit")
    public ModelAndView getEdit(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView();
        ProjectModel projectModel = svc.findProjectModelById(id);
        List<Project> projectList = projectSvc.findProjects(new HashMap<>());
        List<ProjectModel> projectModelList = svc.findProjectModels(new HashMap<>());
        modelAndView.addObject("ProjectList", projectList);
        modelAndView.addObject("ProjectModelList", projectModelList);
        modelAndView.addObject("ProjectModel", projectModel);
        modelAndView.setViewName("ProjectModelEdit");
        return modelAndView;
    }

    @PostMapping("/Save")
    public String Save(@RequestBody String data) {
        if (JSONJudge(data)) {
            ProjectModel projectModel = JSONObject.parseObject(data, ProjectModel.class);
            svc.save(projectModel);
            return commonResp(2000, "保存成功");
        } else {
            return commonResp(4000, "传入数据不为JSON格式字符串");
        }
    }

    @PostMapping("/Update")
    public String Update(@RequestBody String data) {
        if (JSONJudge(data)) {
            ProjectModel projectModel = JSONObject.parseObject(data, ProjectModel.class);
            svc.update(projectModel);
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

    public void DoRootProjectModel(List<ProjectModel> list, List<ProjectModel> det) {
        list.stream().forEach(item -> {
            if (item.getParent().isEmpty()) {
                det.add(item);
                doChiProjectModel(item.getId(), list, det);
            }
        });
    }

    public void doChiProjectModel(String parent, List<ProjectModel> src, List<ProjectModel> det) {
        src.stream().forEach(item -> {
            if (!(item.getParent().isEmpty()) && item.getParent().equalsIgnoreCase(parent)) {
                det.add(item);
                doChiProjectModel(item.getId(), src, det);
            }
        });
    }
}
