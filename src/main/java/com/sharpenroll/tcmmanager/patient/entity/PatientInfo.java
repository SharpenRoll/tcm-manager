package com.sharpenroll.tcmmanager.patient.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sharpenroll.tcmmanager.common.entity.BaseModel;
import lombok.Data;

@Data
@TableName("patient_info")
public class PatientInfo extends BaseModel {

    private String name;
    private Integer gender;
    private String birth;
    private String phone;

}
