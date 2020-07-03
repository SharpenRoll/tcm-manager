package com.sharpenroll.tcmmanager.drug.manager;

import com.sharpenroll.tcmmanager.drug.models.DrugInfoDO;
import com.sharpenroll.tcmmanager.drug.models.DrugInfoVO;

import java.util.List;

public interface DrugInfoManager {

    List<DrugInfoVO> listAll();

    DrugInfoVO getById(int drugInfoId);

    List<DrugInfoVO> getByName(String drugName);

    int save(DrugInfoDO drugInfoDO);

    void delete(int drugInfoId);

}
