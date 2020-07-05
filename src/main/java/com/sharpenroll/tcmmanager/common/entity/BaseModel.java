package com.sharpenroll.tcmmanager.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

}
