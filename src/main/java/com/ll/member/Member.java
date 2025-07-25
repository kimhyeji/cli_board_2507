package com.ll.member;

public class Member {
    int id;
    String userId;
    String password;
    String regDate;

    public Member(int id, String userId, String password, String regDate) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.regDate = regDate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }
}