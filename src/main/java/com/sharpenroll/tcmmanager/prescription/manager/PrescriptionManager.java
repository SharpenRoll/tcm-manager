package com.sharpenroll.tcmmanager.prescription.manager;

import com.sharpenroll.tcmmanager.prescription.models.PrescriptionInfoDO;
import com.sharpenroll.tcmmanager.prescription.models.PrescriptionInfoVO;

import java.util.List;

public interface PrescriptionManager {

    /**
     * 创建新处方单
     *
     * @param patientId 患者id
     * @return 新处方单id
     */
    int createPrescription(int patientId);

    /**
     * 更新处方单内容
     *
     * @param prescriptionInfoDO 新处方单内容
     */
    void updatePrescription(PrescriptionInfoDO prescriptionInfoDO);

    /**
     * 获取给定病患的所有处方单信息
     *
     * @param patientId 病患id
     * @return 该病患所有的处方单信息
     */
    List<PrescriptionInfoVO> getPrescriptionByPatientId(int patientId);

}
