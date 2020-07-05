package com.sharpenroll.tcmmanager.prescription.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sharpenroll.tcmmanager.common.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("prescription_detail")
public class PrescriptionDetail extends BaseModel {

    int prescriptionId;
    int drugId;
    double drugAmount;

}
