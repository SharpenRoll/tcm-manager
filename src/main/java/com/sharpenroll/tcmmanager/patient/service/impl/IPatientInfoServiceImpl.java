package com.sharpenroll.tcmmanager.patient.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharpenroll.tcmmanager.patient.entity.PatientInfo;
import com.sharpenroll.tcmmanager.patient.mapper.PatientInfoMapper;
import com.sharpenroll.tcmmanager.patient.service.IPatientInfoService;
import org.springframework.stereotype.Service;

@Service
public class IPatientInfoServiceImpl extends ServiceImpl<PatientInfoMapper, PatientInfo> implements IPatientInfoService {
}
