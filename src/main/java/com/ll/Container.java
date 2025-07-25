package com.ll;

import com.ll.db.DBConnection;
import com.ll.member.Member;
import java.util.Scanner;

public class Container {
    private static Scanner sc;
    private static DBConnection dbConnection;
    private static Member loginedMember;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getSc() {
        return sc;
    }

    public static DBConnection getDBConnection() {
        if ( dbConnection == null ) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }

    public static Member getLoginedMember() {
        return loginedMember;
    }

    public static void setLoginedMember(Member member) {
        loginedMember = member;
    }
}
