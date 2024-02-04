package com.example.pressresource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@TableName("News")
@NoArgsConstructor
public class Press {
    @TableId(type = IdType.AUTO)
    private Long newsid;
    private String title;
    private String body;
    @TableField("CoverImageUrl")
    private String coverImageUrl;
    private String author;
    @TableField("ViewCount")
    private Integer viewCount = 0;
    @TableField("FavoriteCount")
    private Integer favoriteCount = 0;
    @TableField("ShareCount")
    private Integer shareCount = 0;
    @TableField("PaidPromotion")
    private Boolean paidPromotion = false;
    @TableField("PublishDatetime")
    private Date publishDatetime;
    @TableField(exist = false)
    private List<Advertisement> advertisements;

    public Press(Long id, String title, String body) {
        this.newsid = id;
        this.title = title;
        this.body = body;
    }

    public Press(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void setNewsid(Long newsid) {
        this.newsid = newsid;
    }

    public Long getId() {
        return newsid;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public void setPaidPromotion(Boolean paidPromotion) {
        this.paidPromotion = paidPromotion;
    }

    public void setPublishDatetime(Date publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public void clickOnce(){
        viewCount += 1;
    }

    public void shareOnce(){
        shareCount += 1;
    }

    public void likeOnce(){
        favoriteCount += 1;
    }

    @Override
    public String toString() {
        String adDetails = advertisements == null ? "No advertisements" :
                advertisements.stream()
                        .map(Advertisement::toString)
                        .collect(Collectors.joining(", "));
        return "{" +
                "newsid=" + newsid +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", advertisements=[" + adDetails + "]" +
                '}';
    }
}
