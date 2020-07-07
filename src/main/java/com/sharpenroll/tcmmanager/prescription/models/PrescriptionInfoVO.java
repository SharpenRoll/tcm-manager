package com.sharpenroll.tcmmanager.prescription.models;

import lombok.Data;

@Data
public class PrescriptionInfoVO {

    Integer id;
    Integer patientId;
    PrescriptionContent content;

}
