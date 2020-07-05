package com.sharpenroll.tcmmanager.drug.manager;

import com.sharpenroll.tcmmanager.drug.models.DrugInfoDO;
import com.sharpenroll.tcmmanager.drug.models.DrugInfoVO;

import java.util.List;

public interface DrugInfoManager {

    /**
     * 获取所有药品信息
     *
     * @return 所有药品信息
     */
    List<DrugInfoVO> listAll();

    /**
     * 根据id获取单个药品信息
     *
     * @param drugInfoId 药品id
     * @return 与id对应的单个药品信息
     */
    DrugInfoVO getById(int drugInfoId);

    /**
     * 根据药品名查找药品信息
     *
     * @param drugName 药品名
     * @return 根据药品名模糊查询得到的所有药品信息
     */
    List<DrugInfoVO> getByName(String drugName);

    /**
     * 保存药品信息
     * 若参数结构中的id为空，则会新建药品信息
     * 否则，将会更新该id对应的药品信息
     *
     * @param drugInfoDO 待保存的药品信息
     * @return 药品信息id
     */
    int save(DrugInfoDO drugInfoDO);

    /**
     * 删除药品信息
     *
     * @param drugInfoId 药品id
     */
    void delete(int drugInfoId);

}
