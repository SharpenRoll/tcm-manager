package com.sharpenroll.tcmmanager.drug.manager.impl;

import com.sharpenroll.tcmmanager.drug.entity.DrugInfo;
import com.sharpenroll.tcmmanager.drug.manager.DrugInfoManager;
import com.sharpenroll.tcmmanager.drug.service.IDrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugInfoManagerImpl implements DrugInfoManager {

    @Autowired
    IDrugInfoService drugService;

    @Override
    public List<DrugInfo> listAll() {
        return drugService.list();
    }

}
