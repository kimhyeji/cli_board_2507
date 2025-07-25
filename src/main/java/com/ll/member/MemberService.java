package com.ll.member;

import com.ll.Container;

public class MemberService {
    MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public int join (String userId, String password) {
        return this.memberRepository.join(userId, password);
    }


    public Member memberFindByUserId(String userId) {
        return this.memberRepository.memberFindByUserId(userId);
    }

    public Member memberFindById (int id) {
        return this.memberRepository.memberFindById(id);
    }

    public void login(Member checkedMember) {
        Container.setLoginedMember(checkedMember);
    }

    public void logout() {
        Container.setLoginedMember(null);
    }
}
