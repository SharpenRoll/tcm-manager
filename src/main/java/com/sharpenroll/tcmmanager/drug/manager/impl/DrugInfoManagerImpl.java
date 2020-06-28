package com.sharpenroll.tcmmanager.drug.manager.impl;

import com.github.dozermapper.core.Mapper;
import com.sharpenroll.tcmmanager.drug.entity.DrugInfo;
import com.sharpenroll.tcmmanager.drug.manager.DrugInfoManager;
import com.sharpenroll.tcmmanager.drug.models.DrugInfoDO;
import com.sharpenroll.tcmmanager.drug.models.DrugInfoVO;
import com.sharpenroll.tcmmanager.drug.service.IDrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrugInfoManagerImpl implements DrugInfoManager {

    @Autowired
    Mapper mapper;

    @Autowired
    IDrugInfoService drugService;

    @Override
    public List<DrugInfoVO> listAll() {
        return drugService.list().stream()
                .map(drugInfo -> mapper.map(drugInfo, DrugInfoVO.class))
                .collect(Collectors.toList());
    }

    @Override
    public int save(DrugInfoDO drugInfoDO) {
        DrugInfo drugInfo = mapper.map(drugInfoDO, DrugInfo.class);
        drugService.saveOrUpdate(drugInfo);
        return drugInfo.getId();
    }

    @Override
    public void delete(int drugInfoId) {
        drugService.removeById(drugInfoId);
    }
}
