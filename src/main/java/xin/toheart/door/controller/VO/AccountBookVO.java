package xin.toheart.door.controller.VO;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AccountBookVO {
    private String bookName;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date createTime;
    private String userName;
    private Integer id;
    private Integer userId;
    private Integer accountBookId;

    public Integer getAccountBookId() {
        return accountBookId;
    }

    public void setAccountBookId(Integer accountBookId) {
        this.accountBookId = accountBookId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
