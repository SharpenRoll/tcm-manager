package com.sharpenroll.tcmmanager.drug.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sharpenroll.tcmmanager.common.entity.BaseModel;
import lombok.Data;

@Data
@TableName("drug_info")
public class DrugInfo extends BaseModel {

    private String name;
    private Double price;
    private String unit;
    private Double inventory;

}
