package com.example.pressresource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("Advertiser")
@NoArgsConstructor
public class Advertiser {
    @TableId(type = IdType.AUTO)
    private Long advertiserid;
    private String name;

    public void setAdvertiserid(Long advertiserid) {
        this.advertiserid = advertiserid;
    }

    public void setName(String name) {
        this.name = name;
    }
}