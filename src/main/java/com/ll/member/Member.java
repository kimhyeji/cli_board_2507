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