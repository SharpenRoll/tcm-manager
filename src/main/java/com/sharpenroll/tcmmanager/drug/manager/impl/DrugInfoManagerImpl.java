package com.sharpenroll.tcmmanager.drug.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    IDrugInfoService drugInfoService;

    @Override
    public List<DrugInfoVO> listAll() {
        return MapperUtil.mapList(drugInfoService.list(), DrugInfoVO.class);
    }

    @Override
    public DrugInfoVO getById(int drugInfoId) {
        return MapperUtil.map(drugInfoService.getById(drugInfoId), DrugInfoVO.class);
    }

    @Override
    public List<DrugInfoVO> getByName(String drugName) {
        LambdaQueryWrapper<DrugInfo> queryWrapper = new QueryWrapper<DrugInfo>().lambda()
                .like(DrugInfo::getName, drugName);
        return MapperUtil.mapList(drugInfoService.list(queryWrapper), DrugInfoVO.class);
    }

    @Override
    public int save(DrugInfoDO drugInfoDO) {
        DrugInfo drugInfo = MapperUtil.map(drugInfoDO, DrugInfo.class);
        drugInfoService.saveOrUpdate(drugInfo);
        return drugInfo.getId();
    }

    @Override
    public void delete(int drugInfoId) {
        drugInfoService.removeById(drugInfoId);
    }
}
