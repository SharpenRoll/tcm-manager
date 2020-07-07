package com.sharpenroll.tcmmanager.prescription.models;

import lombok.Data;

@Data
public class PrescriptionInfoVO {

    Integer id;
    int patientId;
    PrescriptionContent content;

}
