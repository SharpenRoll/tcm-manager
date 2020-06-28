package com.sharpenroll.tcmmanager.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("drug_info")
public class DrugInfo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
    private Double price;
    private String unit;

}
