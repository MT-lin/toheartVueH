package xin.toheart.door.pojo;

import java.util.Date;

public class Praise {
    private Integer id;
    private Integer articleId;
    private Integer articleType;
    private Integer userId;
    private Integer status;
    private Date praiseTime;

    public Praise() {
    }

    public Praise(Integer articleId, Integer articleType, Integer userId, Integer status, Date praiseTime) {
        this.articleId = articleId;
        this.articleType = articleType;
        this.userId = userId;
        this.status = status;
        this.praiseTime = praiseTime;
    }
    public Praise(Integer articleId, Integer articleType, Integer userId, Integer status) {
        this.articleId = articleId;
        this.articleType = articleType;
        this.userId = userId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    public Date getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(Date praiseTime) {
        this.praiseTime = praiseTime;
    }
}
