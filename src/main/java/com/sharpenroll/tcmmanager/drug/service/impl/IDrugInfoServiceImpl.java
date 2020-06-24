package com.sharpenroll.tcmmanager.drug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharpenroll.tcmmanager.drug.entity.DrugInfo;
import com.sharpenroll.tcmmanager.drug.mapper.DrugInfoMapper;
import com.sharpenroll.tcmmanager.drug.service.IDrugInfoService;
import org.springframework.stereotype.Service;

@Service
public class IDrugInfoServiceImpl extends ServiceImpl<DrugInfoMapper, DrugInfo> implements IDrugInfoService {
}
