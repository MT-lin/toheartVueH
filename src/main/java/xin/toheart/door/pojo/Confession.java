package xin.toheart.door.pojo;

import java.sql.Date;

public class Confession {
    private Integer confessorId;
    private Integer userId;
    private String confessionContent;
    private Integer confessionLike;
    private Date confessionTime;
    private String confessionImgUrl;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getConfessionImgUrl() {
        return confessionImgUrl;
    }

    public void setConfessionImgUrl(String confessionImgUrl) {
        this.confessionImgUrl = confessionImgUrl;
    }

    public Integer getConfessorId() {
        return confessorId;
    }

    public void setConfessorId(Integer confessorId) {
        this.confessorId = confessorId;
    }

    public String getConfessionContent() {
        return confessionContent;
    }

    public void setConfessionContent(String confessionContent) {
        this.confessionContent = confessionContent;
    }

    public Integer getConfessionLike() {
        return confessionLike;
    }

    public void setConfessionLike(Integer confessionLike) {
        this.confessionLike = confessionLike;
    }

    public Date getConfessionTime() {
        return confessionTime;
    }

    public void setConfessionTime(Date confessionTime) {
        this.confessionTime = confessionTime;
    }

    @Override
    public String toString() {
        return "Confession{" +
                "confessorId=" + confessorId +
                ", userId='" + userId + '\'' +
                ", confessionContent='" + confessionContent + '\'' +
                ", confessionLike=" + confessionLike +
                ", confessionTime=" + confessionTime +
                '}';
    }
}
