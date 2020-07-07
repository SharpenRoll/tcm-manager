package com.sharpenroll.tcmmanager.prescription.models;

import lombok.Data;

import java.util.List;

@Data
public class PrescriptionContent {

    List<PrescriptionDrugInfo> drugList;
    Double totalPrice;
    String comment;

}
