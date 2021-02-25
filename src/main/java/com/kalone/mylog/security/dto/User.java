package com.kalone.mylog.security.dto;

/**
 * 登陆用户对象
 *
 * @author shelin 2021/02/25 9:31
 */

public class User {

    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
