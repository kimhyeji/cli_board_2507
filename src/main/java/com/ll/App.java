package com.ll;

import com.ll.article.ArticleController;
import com.ll.db.DBConnection;
import com.ll.member.MemberController;
import com.ll.system.SystemController;

public class App {
    ArticleController articleController;
    MemberController memberController;
    SystemController systemController;

    App() {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Container.getDBConnection().connect();

        articleController = new ArticleController();
        systemController = new SystemController();
        memberController = new MemberController();
    }

    public void run() {
        System.out.println("== 게시판 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();

            // 커맨드에 입력한 내용을 actionCode, idx로 분류해서 필드로 저장
            Request request = new Request(command);

            switch (command) {
                case "종료":
                    return;
                case "등록":
                    articleController.write();
                    break;
                case "목록":
                    articleController.list();
                    break;
                case "삭제":
                    articleController.delete(request);
                    break;
                case "수정":
                    articleController.modify(request);
                    break;
                case "회원가입":
                    memberController.join();
                    break;
                case "로그인":
                    memberController.login();
                    break;
                case "로그아웃":
                    memberController.logout();
                    break;
                default:
                    System.out.println("존재하지 않는 명령어입니다.");
                    break;
            }
        }
    }
}
