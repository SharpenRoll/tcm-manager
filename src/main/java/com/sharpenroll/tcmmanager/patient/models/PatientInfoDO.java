package com.sharpenroll.tcmmanager.patient.models;

import lombok.Data;

@Data
public class PatientInfoDO {

    private Integer id;
    private String name;
    private Integer gender;
    private String birth;
    private String phone;

}
