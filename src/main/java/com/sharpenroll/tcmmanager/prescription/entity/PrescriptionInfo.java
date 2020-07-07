package com.sharpenroll.tcmmanager.prescription.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sharpenroll.tcmmanager.common.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("prescription_info")
public class PrescriptionInfo extends BaseModel {

    int patientId;
    String content;

    @TableField(update = "datetime('now','localtime')")
    LocalDateTime updateTime;

}
