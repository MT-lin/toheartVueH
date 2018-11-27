package xin.toheart.door.controller.VO;


import java.util.Date;

public class AccountBookVO {
    private String bookName;
    private Date createTime;
    private String userName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userNamr) {
        this.userName = userNamr;
    }
}
