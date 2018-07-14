package xin.toheart.door.pojo;

import java.sql.Date;

public class Confession {
    private Integer confessorId;
    private String confessor;
    private String confessionContent;
    private Integer confessionLike;
    private Date confessionTime;

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

    @Override
    public String toString() {
        return "Confession{" +
                "confessorId=" + confessorId +
                ", confessor='" + confessor + '\'' +
                ", confessionContent='" + confessionContent + '\'' +
                ", confessionLike=" + confessionLike +
                ", confessionTime=" + confessionTime +
                '}';
    }
}
