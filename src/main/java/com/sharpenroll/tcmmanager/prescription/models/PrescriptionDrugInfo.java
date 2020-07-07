package com.sharpenroll.tcmmanager.prescription.models;

import com.sharpenroll.tcmmanager.drug.entity.DrugInfo;
import lombok.Data;

@Data
public class PrescriptionDrugInfo {

    DrugInfo drugInfo;
    Double amount;

}
