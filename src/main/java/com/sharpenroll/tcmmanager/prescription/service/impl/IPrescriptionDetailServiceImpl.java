package com.sharpenroll.tcmmanager.prescription.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharpenroll.tcmmanager.prescription.entity.PrescriptionDetail;
import com.sharpenroll.tcmmanager.prescription.mapper.PrescriptionDetailMapper;
import com.sharpenroll.tcmmanager.prescription.service.IPrescriptionDetailService;
import org.springframework.stereotype.Service;

@Service
public class IPrescriptionDetailServiceImpl extends ServiceImpl<PrescriptionDetailMapper, PrescriptionDetail> implements IPrescriptionDetailService {
}
