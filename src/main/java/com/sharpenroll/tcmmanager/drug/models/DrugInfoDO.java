package com.sharpenroll.tcmmanager.drug.models;

import lombok.Data;

@Data
public class DrugInfoDO {

    private Integer id;
    private String name;
    private Double price;
    private String unit;
    private Double inventory;

}
