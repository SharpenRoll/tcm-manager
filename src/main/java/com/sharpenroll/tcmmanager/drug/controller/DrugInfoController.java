package com.sharpenroll.tcmmanager.drug.controller;

import com.sharpenroll.tcmmanager.drug.manager.DrugInfoManager;
import com.sharpenroll.tcmmanager.drug.models.DrugInfoDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api("药品管理接口")
@RestController
@RequestMapping("/drug")
public class DrugInfoController {

    @Autowired
    DrugInfoManager drugInfoManager;

    @RequestMapping("/list")
    @ApiOperation(value = "列出所有药品信息", httpMethod = "GET")
    @ResponseBody
    public Object list() {
        return drugInfoManager.listAll();
    }

    @RequestMapping("/getById")
    @ApiOperation(value = "获取单个药品信息", httpMethod = "GET")
    @ResponseBody
    public Object getById(
            @ApiParam(name = "药品信息id", required = true) @RequestParam int drugInfoId
    ) {
        return drugInfoManager.getById(drugInfoId);
    }

    @RequestMapping("/getByName")
    @ApiOperation(value = "按药品名查询药品信息", httpMethod = "GET")
    @ResponseBody
    public Object getByName(
            @ApiParam(name = "药品名", required = true) @RequestParam String drugName
    ) {
        return drugInfoManager.getByName(drugName);
    }

    @RequestMapping("/save")
    @ApiOperation(value = "保存药品信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object save(
            @ApiParam(name = "药品信息", required = true) @RequestBody DrugInfoDO drugInfoDO
    ) {
        return drugInfoManager.save(drugInfoDO);
    }

    @RequestMapping("/delete")
    @ApiOperation(value = "删除药品信息", httpMethod = "DELETE")
    @ResponseBody
    public Object delete(
            @ApiParam(name = "药品信息id", required = true) @RequestParam int drugInfoId
    ) {
        drugInfoManager.delete(drugInfoId);
        return null;
    }

}
