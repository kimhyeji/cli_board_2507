package com.ll.member;

import java.util.Map;

public class Member {
    int id;
    String userId;
    String password;
    String regDate;

    public Member (Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.userId = (String)row.get("userId");
        this.password = (String)row.get("password");
        this.regDate = row.get("regDate").toString();
    }

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

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }
}