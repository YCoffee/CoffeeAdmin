package com.gdyx.apidoc.ctrl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gdyx.apidoc.model.Api;
import com.gdyx.apidoc.model.ApiResponseExample;
import com.gdyx.apidoc.svc.ApiResponseExampleSvc;
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
@RestController("/ApiResponseExampleController")
@RequestMapping("ApiResponseExample")
public class ApiResponseExampleController extends BaseController {
    @Autowired
    ApiResponseExampleSvc svc;
    @Autowired
    ApiSvc apiSvc;

    @GetMapping("/goApiResponseExample")
    public ModelAndView goApiResponseExample() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ApiResponseExamples");
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
        List<ApiResponseExample> apiResponseExampleList = svc.findApiResponseExamplesLinkApi(map);
        PageInfo pageInfo = new PageInfo(apiResponseExampleList);
        JSONArray returnJSON = new JSONArray();
        apiResponseExampleList.stream().forEach(p -> {
            returnJSON.add(p);
        });
        return commonMsgResp(2000, "获取成功", pageInfo.getTotal(), returnJSON);
    }

    @GetMapping("/goAdd")
    public ModelAndView goAdd() {
        ModelAndView modelAndView = new ModelAndView();
        List<Api> apiList = apiSvc.findApis(new HashMap<>());
        modelAndView.addObject("ApiList", apiList);
        modelAndView.setViewName("ApiResponseExampleAdd");
        return modelAndView;
    }

    @GetMapping("/getEdit")
    public ModelAndView getEdit(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Api> apiList = apiSvc.findApis(new HashMap<>());
        ApiResponseExample apiResponseExample = svc.findApiResponseExampleById(id);
        modelAndView.addObject("ApiResponseExample", apiResponseExample);
        modelAndView.addObject("ApiList", apiList);
        modelAndView.setViewName("ApiResponseExampleEdit");
        return modelAndView;
    }

    @PostMapping("/Save")
    public String Save(@RequestBody String data) {
        if (JSONJudge(data)) {
            ApiResponseExample apiResponseExample = JSONObject.parseObject(data, ApiResponseExample.class);
            svc.save(apiResponseExample);
            return commonResp(2000, "保存成功");
        } else {
            return commonResp(4000, "传入数据不为JSON格式字符串");
        }
    }

    @PostMapping("/Update")
    public String Update(@RequestBody String data) {
        if (JSONJudge(data)) {
            ApiResponseExample apiResponseExample = JSONObject.parseObject(data, ApiResponseExample.class);
            svc.update(apiResponseExample);
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
