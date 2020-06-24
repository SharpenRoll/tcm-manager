package com.sharpenroll.tcmmanager.drug.controller;

import com.sharpenroll.tcmmanager.drug.manager.DrugInfoManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
