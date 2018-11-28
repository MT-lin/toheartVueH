package xin.toheart.door.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 记账本
 */
public class AccountBook implements Serializable {
    private int id;
    private String bookName;
    private Integer userId;
    private Date createTime;
    private String command;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AccountBook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", command='" + command + '\'' +
                '}';
    }
}
