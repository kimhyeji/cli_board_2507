package com.ll.member;

import com.ll.Container;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberController {

    List<Member> memberList = new ArrayList<>();
    int lastMemberId;

    public MemberController() {
        lastMemberId = 0;
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

            Member member = _memberFindByUserid(userId);

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

        lastMemberId++;
        Member member = new Member(lastMemberId, userId, password, LocalDate.now().toString());
        memberList.add(member);

        System.out.println(userId + "님 가입을 환영합니다.");
    }

    private Member _memberFindByUserid(String userId) {
        for (Member member : memberList) {
            if (userId.equals(member.getUserId())) {
                return member;
            }
        }
        return null;
    }
}
