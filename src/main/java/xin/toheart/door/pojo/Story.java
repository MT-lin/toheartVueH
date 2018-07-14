package xin.toheart.door.pojo;

import java.sql.Date;

public class Story {
    private Integer storyId;
    private String storyTitle;
    private Date storyTime;
    private String storyImgUrl;
    private String storyAutor;
    private Integer storyZan;
    private String storyContent;
    private String storyBrief;

    public String getStoryBrief() {
        return storyBrief;
    }

    @Override
    public String toString() {
        return "Story{" +
                "storyId=" + storyId +
                ", storyTitle='" + storyTitle + '\'' +
                ", storyTime=" + storyTime +
                ", storyImgUrl='" + storyImgUrl + '\'' +
                ", storyAutor='" + storyAutor + '\'' +
                ", storyZan=" + storyZan +
                ", storyContent='" + storyContent + '\'' +
                ", storyBrief='" + storyBrief + '\'' +
                '}';
    }

    public void setStoryBrief(String storyBrief) {
        this.storyBrief = storyBrief;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public Date getStoryTime() {
        return storyTime;
    }

    public void setStoryTime(Date storyTime) {
        this.storyTime = storyTime;
    }

    public String getStoryImgUrl() {
        return storyImgUrl;
    }

    public void setStoryImgUrl(String storyImgUrl) {
        this.storyImgUrl = storyImgUrl;
    }

    public String getStoryAutor() {
        return storyAutor;
    }

    public void setStoryAutor(String storyAutor) {
        this.storyAutor = storyAutor;
    }

    public Integer getStoryZan() {
        return storyZan;
    }

    public void setStoryZan(Integer storyZan) {
        this.storyZan = storyZan;
    }

    public String getStoryContent() {
        return storyContent;
    }

    public void setStoryContent(String storyContent) {
        this.storyContent = storyContent;
    }

}
