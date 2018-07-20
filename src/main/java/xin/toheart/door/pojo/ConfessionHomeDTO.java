package xin.toheart.door.pojo;

import java.util.Date;

public class ConfessionHomeDTO {
    private Integer confessorId;
    private String confessor;
    private String confessionContent;
    private Integer confessionLike;
    private Date confessionTime;
    private Integer articleType;
    private Integer userId;
    private Integer status;

    @Override
    public String toString() {
        return "ConfessionHomeDTO{" +
                "confessorId=" + confessorId +
                ", confessor='" + confessor + '\'' +
                ", confessionContent='" + confessionContent + '\'' +
                ", confessionLike=" + confessionLike +
                ", confessionTime=" + confessionTime +
                ", articleType=" + articleType +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }

    public Integer getConfessorId() {
        return confessorId;
    }

    public void setConfessorId(Integer confessorId) {
        this.confessorId = confessorId;
    }

    public String getConfessor() {
        return confessor;
    }

    public void setConfessor(String confessor) {
        this.confessor = confessor;
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

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
