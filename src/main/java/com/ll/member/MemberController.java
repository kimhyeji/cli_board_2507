package com.ll.member;

import com.ll.Container;

public class MemberController {
    MemberService memberService;

    public MemberController () {
        memberService = new MemberService();
    }

    public void join () {
        String userId;
        String password;
        String passwordConfirm;

        // 중복 아이디 검증
        while (true) {
            System.out.printf("아이디 : ");
            userId = Container.getSc().nextLine().trim();
            boolean isDuplcated = false;

            Member member = memberService.memberFindByUserId(userId);

            if (member != null) {
                System.out.println("중복 아이디가 존재합니다.");
                isDuplcated = true;
            }

            // 중복 아이디가 없는 경우
            if (!isDuplcated) {
                break;
            }

        }

        while (true) {
            System.out.printf("비밀번호 : ");
            password = Container.getSc().nextLine().trim();

            System.out.printf("비밀번호 확인 : ");
            passwordConfirm = Container.getSc().nextLine().trim();

            if (password.equals(passwordConfirm)) {
                break;
            }

            System.out.println("비밀번호가 일치하지 않습니다.");
        }

        int memberId = this.memberService.join(userId, password);

        if (memberId == -1) {
            System.out.println("회원가입에 실패하였습니다.");
            return;
        }

        System.out.println(userId + "님 가입을 환영합니다.");

    }

    public void login() {
        if (Container.getLoginedMember() != null) {
            System.out.println("현재 로그인 상태입니다.");
            return;
        }

        Member checkedMember = null;

        System.out.printf("아이디 : ");
        String userId = Container.getSc().nextLine().trim();
        System.out.printf("비밀번호 : ");
        String password = Container.getSc().nextLine().trim();

        Member member = this.memberService.memberFindByUserId(userId);
        checkedMember = member;

        if (checkedMember == null) {
            System.out.println("해당 회원이 존재하지 않습니다.");
            return;
        } else if (checkedMember.getPassword().equals(password) == false) {
            System.out.println("비밀번호가 일치 하지 않습니다.");
            return;
        }

        this.memberService.login(checkedMember);

        System.out.println(checkedMember.getUserId() + "님 환영합니다.");
    }

    public void logout () {
        if (Container.getLoginedMember() == null) {
            System.out.println("로그인 상태가 아닙니다.");
            return;
        }

        this.memberService.logout();

        System.out.println("로그아웃 되었습니다.");
    }
}
