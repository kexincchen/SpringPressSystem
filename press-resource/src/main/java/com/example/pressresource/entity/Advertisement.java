package com.example.pressresource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@TableName("Advertisements")
@NoArgsConstructor
public class Advertisement {
    @TableId(type = IdType.AUTO)
    private Long adid;
    private String title;
    @TableField("TextContent")
    private String textContent;
    private Placement placement;
    @TableField("ClickCount")
    private Integer clickCount;
    private Long newsid;
    @TableField("ImageUrl")
    private String imageUrl;
    private Long advertiserid;
    @TableField("ValidUntil")
    private Date validUntil;
    @TableField("ExposureCount")
    private Integer exposureCount;
    private Integer weight;

    public Advertisement(String title, String textContent, String placement, Long newsid) {
        this.title = title;
        this.textContent = textContent;
        this.placement = Placement.fromString(placement);
        this.clickCount = 0;
        this.newsid = newsid;
    }

    public void clickOnce(){
        clickCount += 1;
    }

    public void setAdid(Long adid) {
        this.adid = adid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setPlacement(String placementString) {
        this.placement = Placement.fromString(placementString);
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public void setNewsid(Long newsid) {
        this.newsid = newsid;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAdvertiserid(Long advertiserid) {
        this.advertiserid = advertiserid;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public void setExposureCount(Integer exposureCount) {
        this.exposureCount = exposureCount;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" +
                "adid=" + adid +
                ", title='" + title + '\'' +
                ", textContent='" + textContent + '\'' +
                ", placement=" + placement +
                ", clickCount=" + clickCount +
                '}';
    }
}
