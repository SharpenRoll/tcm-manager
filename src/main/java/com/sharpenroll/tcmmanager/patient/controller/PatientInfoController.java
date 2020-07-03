package com.sharpenroll.tcmmanager.patient.controller;

import com.sharpenroll.tcmmanager.patient.manager.PatientInfoManager;
import com.sharpenroll.tcmmanager.patient.models.PatientInfoDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api("患者信息管理接口")
@RestController
@RequestMapping("/patient")
public class PatientInfoController {

    @Autowired
    PatientInfoManager patientInfoManager;

    @RequestMapping("/list")
    @ApiOperation(value = "列出所有患者信息", httpMethod = "GET")
    @ResponseBody
    public Object list() {
        return patientInfoManager.listAll();
    }

    @RequestMapping("/getById")
    @ApiOperation(value = "获取单个患者信息", httpMethod = "GET")
    @ResponseBody
    public Object getById(
            @ApiParam(name = "患者信息id", required = true) @RequestParam int patientInfoId
    ) {
        return patientInfoManager.getById(patientInfoId);
    }

    @RequestMapping("/save")
    @ApiOperation(value = "保存患者信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object save(
            @ApiParam(name = "患者信息", required = true) @RequestBody PatientInfoDO patientInfoDO
    ) {
        return patientInfoManager.save(patientInfoDO);
    }

    @RequestMapping("/delete")
    @ApiOperation(value = "保存患者信息", httpMethod = "DELETE")
    @ResponseBody
    public Object delete(
            @ApiParam(name = "患者信息id", required = true) @RequestParam int patientInfoId
    ) {
        patientInfoManager.delete(patientInfoId);
        return null;
    }

}
