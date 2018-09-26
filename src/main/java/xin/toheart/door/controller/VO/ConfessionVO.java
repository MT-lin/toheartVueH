package xin.toheart.door.controller.VO;

import java.sql.Date;

/**
 * Created by Administrator on 2018/9/14.
 */
public class ConfessionVO {
    private Integer confessorId;
    private Integer userId;
    private String confessionContent;
    private Integer confessionLike;
    private Integer confessionCommentNum;
    private Date confessionTime;
    private String confessionImgUrl;

    private String userName;
    private String  gender;
    private String province;
    private String city;
    private String imgUrl;

    public Integer getConfessionCommentNum() {
        return confessionCommentNum;
    }

    public void setConfessionCommentNum(Integer confessionCommentNum) {
        this.confessionCommentNum = confessionCommentNum;
    }

    public Integer getConfessorId() {
        return confessorId;
    }

    public void setConfessorId(Integer confessorId) {
        this.confessorId = confessorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getConfessionImgUrl() {
        return confessionImgUrl;
    }

    public void setConfessionImgUrl(String confessionImgUrl) {
        this.confessionImgUrl = confessionImgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "ConfessionVO{" +
                "confessorId=" + confessorId +
                ", userId=" + userId +
                ", confessionContent='" + confessionContent + '\'' +
                ", confessionLike=" + confessionLike +
                ", confessionCommentNum=" + confessionCommentNum +
                ", confessionTime=" + confessionTime +
                ", confessionImgUrl='" + confessionImgUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
