package com.sharpenroll.tcmmanager.prescription.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharpenroll.tcmmanager.prescription.entity.PrescriptionInfo;
import com.sharpenroll.tcmmanager.prescription.mapper.PrescriptionInfoMapper;
import com.sharpenroll.tcmmanager.prescription.service.IPrescriptionInfoService;
import org.springframework.stereotype.Service;

@Service
public class IPrescriptionInfoServiceImpl extends ServiceImpl<PrescriptionInfoMapper, PrescriptionInfo> implements IPrescriptionInfoService {
}
