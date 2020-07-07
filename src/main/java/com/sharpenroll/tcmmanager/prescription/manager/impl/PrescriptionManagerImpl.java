package com.sharpenroll.tcmmanager.prescription.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sharpenroll.tcmmanager.prescription.entity.PrescriptionDetail;
import com.sharpenroll.tcmmanager.prescription.entity.PrescriptionInfo;
import com.sharpenroll.tcmmanager.prescription.manager.PrescriptionManager;
import com.sharpenroll.tcmmanager.prescription.models.PrescriptionContent;
import com.sharpenroll.tcmmanager.prescription.models.PrescriptionDrugInfo;
import com.sharpenroll.tcmmanager.prescription.models.PrescriptionInfoDO;
import com.sharpenroll.tcmmanager.prescription.models.PrescriptionInfoVO;
import com.sharpenroll.tcmmanager.prescription.service.IPrescriptionDetailService;
import com.sharpenroll.tcmmanager.prescription.service.IPrescriptionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionManagerImpl implements PrescriptionManager {

    @Autowired
    IPrescriptionInfoService prescriptionInfoService;
    @Autowired
    IPrescriptionDetailService prescriptionDetailService;

    @Override
    public int createPrescription(int patientId) {
        PrescriptionInfo prescriptionInfo = new PrescriptionInfo();
        prescriptionInfo.setPatientId(patientId);
        prescriptionInfoService.save(prescriptionInfo);
        return prescriptionInfo.getId();
    }

    @Override
    @Transactional
    public void updatePrescription(PrescriptionInfoDO prescriptionInfoDO) {
        PrescriptionInfo prescriptionInfo = transToEntity(prescriptionInfoDO);
        prescriptionInfoService.updateById(prescriptionInfo);
        updatePrescriptionDrugInfo(prescriptionInfoDO.getId(), prescriptionInfoDO.getContent().getDrugList());
    }

    /**
     * 更新处方单中包含的药品信息
     * \@Transactional注解不支持private方法，故将其设为protected
     *
     * @param prescriptionInfoId 处方单id
     * @param drugList           处方单中包含的药品信息
     */
    @Transactional
    protected void updatePrescriptionDrugInfo(Integer prescriptionInfoId, List<PrescriptionDrugInfo> drugList) {
        //删除旧药品信息记录
        LambdaQueryWrapper<PrescriptionDetail> queryWrapper = new QueryWrapper<PrescriptionDetail>().lambda()
                .eq(PrescriptionDetail::getPrescriptionId, prescriptionInfoId);
        prescriptionDetailService.remove(queryWrapper);
        //保存新药品信息
        List<PrescriptionDetail> prescriptionDetailList = drugList.stream()
                .map(prescriptionDrugInfo -> {
                    PrescriptionDetail prescriptionDetail = transToEntity(prescriptionDrugInfo);
                    prescriptionDetail.setPrescriptionId(prescriptionInfoId);
                    return prescriptionDetail;
                })
                .collect(Collectors.toList());
        prescriptionDetailService.saveBatch(prescriptionDetailList);
    }

    @Override
    public List<PrescriptionInfoVO> getPrescriptionByPatientId(int patientId) {
        LambdaQueryWrapper<PrescriptionInfo> queryWrapper = new QueryWrapper<PrescriptionInfo>().lambda()
                .eq(PrescriptionInfo::getPatientId, patientId);
        List<PrescriptionInfo> prescriptionInfoList = prescriptionInfoService.list(queryWrapper);
        return prescriptionInfoList.stream()
                .map(this::transToVO)
                .collect(Collectors.toList());
    }

    /**
     * 将处方单中的药品信息转化为实体类
     *
     * @param prescriptionDrugInfo 处方单中的药品信息
     * @return 处方单药品信息实体类
     */
    private PrescriptionDetail transToEntity(PrescriptionDrugInfo prescriptionDrugInfo) {
        PrescriptionDetail prescriptionDetail = new PrescriptionDetail();
        prescriptionDetail.setDrugId(prescriptionDrugInfo.getDrugInfo().getId());
        prescriptionDetail.setDrugAmount(prescriptionDrugInfo.getAmount());
        return prescriptionDetail;
    }

    /**
     * 将处方单信息DO转化为实体类
     *
     * @param prescriptionInfoDO 处方单信息DO
     * @return 对应的处方单信息实体类
     */
    private PrescriptionInfo transToEntity(PrescriptionInfoDO prescriptionInfoDO) {
        PrescriptionInfo prescriptionInfo = new PrescriptionInfo();
        prescriptionInfo.setId(prescriptionInfoDO.getId());
        prescriptionInfo.setPatientId(prescriptionInfoDO.getPatientId());
        prescriptionInfo.setContent(JSONObject.toJSONString(prescriptionInfoDO.getContent()));
        return prescriptionInfo;
    }

    /**
     * 将处方单信息实体类转化为VO
     *
     * @param prescriptionInfo 处方单信息实体类
     * @return 对应的处方单信息VO
     */
    private PrescriptionInfoVO transToVO(PrescriptionInfo prescriptionInfo) {
        PrescriptionInfoVO prescriptionInfoVO = new PrescriptionInfoVO();
        prescriptionInfoVO.setId(prescriptionInfo.getId());
        prescriptionInfoVO.setPatientId(prescriptionInfo.getPatientId());
        prescriptionInfoVO.setContent(JSONObject.parseObject(prescriptionInfo.getContent(), PrescriptionContent.class));
        return prescriptionInfoVO;
    }

}
