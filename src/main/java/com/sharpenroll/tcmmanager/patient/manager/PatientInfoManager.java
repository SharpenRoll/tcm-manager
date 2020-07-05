package com.sharpenroll.tcmmanager.patient.manager;

import com.sharpenroll.tcmmanager.patient.models.PatientInfoDO;
import com.sharpenroll.tcmmanager.patient.models.PatientInfoVO;

import java.util.List;

public interface PatientInfoManager {

    /**
     * 获取所有患者信息
     *
     * @return 所有患者信息
     */
    List<PatientInfoVO> listAll();

    /**
     * 根据id获取单个患者信息
     *
     * @param patientInfoId 患者id
     * @return 与id对应的单个患者信息
     */
    PatientInfoVO getById(int patientInfoId);

    /**
     * 根据名字查找患者信息
     *
     * @param PatientName 患者姓名
     * @return 根据患者姓名模糊查询得到的所有患者信息
     */
    List<PatientInfoVO> getByName(String PatientName);

    /**
     * 保存患者信息
     * 若参数结构中的id为空，则会新建患者信息
     * 否则，将会更新该id对应的患者信息
     *
     * @param patientInfoDO 待保存的患者信息
     * @return 患者信息id
     */
    int save(PatientInfoDO patientInfoDO);

    /**
     * 删除患者信息
     *
     * @param patientInfoId 患者id
     */
    void delete(int patientInfoId);

}
