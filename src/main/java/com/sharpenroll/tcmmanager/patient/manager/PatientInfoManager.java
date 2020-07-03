package com.sharpenroll.tcmmanager.patient.manager;

import com.sharpenroll.tcmmanager.patient.models.PatientInfoDO;
import com.sharpenroll.tcmmanager.patient.models.PatientInfoVO;

import java.util.List;

public interface PatientInfoManager {

    List<PatientInfoVO> listAll();

    PatientInfoVO getById(int patientInfoId);

    List<PatientInfoVO> getByName(String PatientName);

    int save(PatientInfoDO patientInfoDO);

    void delete(int patientInfoId);

}
