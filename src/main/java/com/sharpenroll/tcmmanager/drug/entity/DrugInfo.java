package com.sharpenroll.tcmmanager.drug.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("drug_info")
public class DrugInfo {

    private int id;
    private String name;
    private Double price;
    private String unit;

}
