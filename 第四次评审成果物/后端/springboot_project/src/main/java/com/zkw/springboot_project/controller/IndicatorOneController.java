package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.IndicatorOneDao;
import com.zkw.springboot_project.entity.IndicatorOne;
import com.zkw.springboot_project.entity.QueryInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(description = "管理一级指标信息")
@RestController
@RequestMapping("/IndicatorOnes")
public class IndicatorOneController {

    @Autowired
    private final IndicatorOneDao indicatorOneDao;

    public IndicatorOneController(IndicatorOneDao indicatorOneDao){
        this.indicatorOneDao = indicatorOneDao;
    }

    @ApiOperation(value = "查询全部一级指标信息")
    @GetMapping("/AllIndicatorOne")
    public String getIndicatorOneList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = indicatorOneDao.getIndicatorOneCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<IndicatorOne> indicatorOnes = indicatorOneDao.getAllIndicatorOne("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",indicatorOnes);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "添加一级指标信息")
    @PostMapping("/IndicatorOne")
    public String addIndicatorOne(@RequestBody IndicatorOne indicatorOne){
        System.out.println(indicatorOne);
        int state = indicatorOneDao.addIndicatorOne(indicatorOne);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除一级指标")
    @DeleteMapping("/IndicatorOne")
    public String deleteIndicatorOne(String findicname){
        System.out.println(findicname);
        int state = indicatorOneDao.deleteIndicatorOne(findicname);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "获取要更新的一级指标信息")
    @GetMapping("/IndicatorOneMessage")
    public String getUpdateIndicatorOne(String findicname){
        System.out.println("一级指标名称:" + findicname);
        IndicatorOne updateIndicatorOne = indicatorOneDao.getUpdateIndicatorOne(findicname);
        String users_json = JSON.toJSONString(updateIndicatorOne);
        return users_json;
    }

    @ApiOperation(value = "更新一级指标信息")
    @PutMapping("/IndicatorOne")
    public String editIndicatorOne(@RequestBody IndicatorOne indicatorOne){
        System.out.println(indicatorOne);
        int state = indicatorOneDao.editIndicatorOne(indicatorOne);
        String str = state >0?"success":"error";
        return str;
    }
}
