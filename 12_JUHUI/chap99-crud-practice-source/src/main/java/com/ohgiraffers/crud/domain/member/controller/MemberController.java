package com.ohgiraffers.crud.domain.member.controller;

import com.ohgiraffers.crud.domain.member.dto.Member;
import com.ohgiraffers.crud.domain.member.repository.MemberRepository;
import com.ohgiraffers.crud.domain.member.service.MemberService;

import java.util.List;

public class MemberController {

    private MemberService memberService = new MemberService();

    // 회원 전체 조회
    public List<Member> selectAllMembers() {
        return memberService.findAllMembers();
    }

    // 회원 가입
    public int insertMember(Member member) {
        return memberService.joinMember(member);
    }

    // 회원 찾기
    public Member selectMemberById(String memberId) {
        return memberService.findMemberById(memberId);
    }

    // 회원 정보 수정
    public int updateMember(Member member) {
        return memberService.modifyMember(member);
    }

    // 회원 탈퇴
     public int deleteMember(String memberId) {
        return memberService.removeMember(memberId);
     }
}
