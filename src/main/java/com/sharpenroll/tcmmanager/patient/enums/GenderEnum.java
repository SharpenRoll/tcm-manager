package com.sharpenroll.tcmmanager.patient.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum {
    MALE(0, "男性"),
    FEMALE(1, "女性");

    private final int num;
    private final String desc;

}
