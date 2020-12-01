package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.IndicatorTwoDao;
import com.zkw.springboot_project.entity.IndicatorTwo;
import com.zkw.springboot_project.entity.QueryInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(description = "管理二级指标信息")
@RestController
@RequestMapping("/IndicatorTwos")
public class IndicatorTwoController {
    @Autowired
    private final IndicatorTwoDao indicatorTwoDao;

    public IndicatorTwoController(IndicatorTwoDao indicatorTwoDao){
        this.indicatorTwoDao = indicatorTwoDao;
    }

    @ApiOperation(value = "查询全部二级指标信息")
    @GetMapping("/AllIndicatorTwo")
    public String getIndicatorTwoList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = indicatorTwoDao.getIndicatorTwoCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<IndicatorTwo> indicatorTwos = indicatorTwoDao.getAllIndicatorTwo("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",indicatorTwos);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "添加二级指标信息")
    @PostMapping("/IndicatorTwo")
    public String addIndicatorTwo(@RequestBody IndicatorTwo indicatorTwo){
        System.out.println(indicatorTwo);
        int state = indicatorTwoDao.addIndicatorTwo(indicatorTwo);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除二级指标")
    @DeleteMapping("/IndicatorTwo")
    public String deleteIndicatorTwo(String sindicname){
        System.out.println(sindicname);
        int state = indicatorTwoDao.deleteIndicatorTwo(sindicname);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "获取要更新的二级指标信息")
    @GetMapping("/IndicatorTwoMessage")
    public String getUpdateIndicatorTwo(String sindicname){
        System.out.println("二级指标名称:" + sindicname);
        IndicatorTwo updateIndicatorTwo = indicatorTwoDao.getUpdateIndicatorTwo(sindicname);
        String users_json = JSON.toJSONString(updateIndicatorTwo);
        return users_json;
    }

    @ApiOperation(value = "更新二级指标信息")
    @PutMapping("/IndicatorTwo")
    public String editIndicatorTwo(@RequestBody IndicatorTwo indicatorTwo){
        System.out.println(indicatorTwo);
        int state = indicatorTwoDao.editIndicatorTwo(indicatorTwo);
        String str = state >0?"success":"error";
        return str;
    }
}
