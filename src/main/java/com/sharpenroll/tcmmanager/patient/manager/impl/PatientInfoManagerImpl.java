package com.sharpenroll.tcmmanager.patient.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sharpenroll.tcmmanager.common.utils.MapperUtil;
import com.sharpenroll.tcmmanager.patient.entity.PatientInfo;
import com.sharpenroll.tcmmanager.patient.manager.PatientInfoManager;
import com.sharpenroll.tcmmanager.patient.models.PatientInfoDO;
import com.sharpenroll.tcmmanager.patient.models.PatientInfoVO;
import com.sharpenroll.tcmmanager.patient.service.IPatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientInfoManagerImpl implements PatientInfoManager {

    @Autowired
    IPatientInfoService patientInfoService;

    @Override
    public List<PatientInfoVO> listAll() {
        return MapperUtil.mapList(patientInfoService.list(), PatientInfoVO.class);
    }

    @Override
    public PatientInfoVO getById(int patientInfoId) {
        PatientInfo patientInfo = patientInfoService.getById(patientInfoId);
        return MapperUtil.map(patientInfo, PatientInfoVO.class);
    }

    @Override
    public List<PatientInfoVO> getByName(String patientName) {
        LambdaQueryWrapper<PatientInfo> queryWrapper = new QueryWrapper<PatientInfo>().lambda()
                .like(PatientInfo::getName, patientName);
        return MapperUtil.mapList(patientInfoService.list(queryWrapper), PatientInfoVO.class);
    }

    @Override
    public int save(PatientInfoDO patientInfoDO) {
        PatientInfo patientInfo = MapperUtil.map(patientInfoDO, PatientInfo.class);
        patientInfoService.saveOrUpdate(patientInfo);
        return patientInfo.getId();
    }

    @Override
    public void delete(int patientInfoId) {
        patientInfoService.removeById(patientInfoId);
    }

}
