package com.sharpenroll.tcmmanager.drug.manager.impl;

import com.sharpenroll.tcmmanager.common.utils.MapperUtil;
import com.sharpenroll.tcmmanager.drug.entity.DrugInfo;
import com.sharpenroll.tcmmanager.drug.manager.DrugInfoManager;
import com.sharpenroll.tcmmanager.drug.models.DrugInfoDO;
import com.sharpenroll.tcmmanager.drug.models.DrugInfoVO;
import com.sharpenroll.tcmmanager.drug.service.IDrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugInfoManagerImpl implements DrugInfoManager {

    @Autowired
    IDrugInfoService drugService;

    @Override
    public List<DrugInfoVO> listAll() {
        return MapperUtil.mapList(drugService.list(), DrugInfoVO.class);
    }

    @Override
    public int save(DrugInfoDO drugInfoDO) {
        DrugInfo drugInfo = MapperUtil.map(drugInfoDO, DrugInfo.class);
        drugService.saveOrUpdate(drugInfo);
        return drugInfo.getId();
    }

    @Override
    public void delete(int drugInfoId) {
        drugService.removeById(drugInfoId);
    }
}
