package com.sharpenroll.tcmmanager.prescription.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sharpenroll.tcmmanager.prescription.entity.PrescriptionInfo;
import com.sharpenroll.tcmmanager.prescription.manager.PrescriptionManager;
import com.sharpenroll.tcmmanager.prescription.service.IPrescriptionDetailService;
import com.sharpenroll.tcmmanager.prescription.service.IPrescriptionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionManagerImpl implements PrescriptionManager {

    @Autowired
    IPrescriptionInfoService prescriptionInfoService;
    @Autowired
    IPrescriptionDetailService prescriptionDetailService;

    public void getPrescriptionByPatientId(int patientId){
        LambdaQueryWrapper<PrescriptionInfo> queryWrapper = new QueryWrapper<PrescriptionInfo>().lambda()
                .eq(PrescriptionInfo::getPatientId, patientId);
        List<PrescriptionInfo> prescriptionInfoList = prescriptionInfoService.list(queryWrapper);
    }

}
