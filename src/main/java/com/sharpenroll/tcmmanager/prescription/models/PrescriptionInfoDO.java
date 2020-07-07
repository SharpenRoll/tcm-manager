package com.sharpenroll.tcmmanager.prescription.models;

import lombok.Data;

@Data
public class PrescriptionInfoDO {

    Integer id;
    Integer patientId;
    PrescriptionContent content;

}
