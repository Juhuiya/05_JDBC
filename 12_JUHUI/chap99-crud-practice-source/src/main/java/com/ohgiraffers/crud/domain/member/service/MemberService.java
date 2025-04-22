package com.ohgiraffers.crud.domain.member.service;

import com.ohgiraffers.crud.domain.member.dto.Member;
import com.ohgiraffers.crud.domain.member.repository.MemberRepository;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.crud.common.JDBCTemplate.close;
import static com.ohgiraffers.crud.common.JDBCTemplate.getConnection;

public class MemberService {

    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public void selectAllMembers() {

        Connection con = getConnection();

        List<Member> memberList = memberRepository.selectAllMembers(con);

        for(Member member : memberList) {
            System.out.println(member);
        }

        close(con);
    }

    // 회원가입
    public int joinMember(Member member) {
        // 비즈니스 로직(유효성 검사 등)
        return memberRepository.insertMember(member);
    }

    // 로그인
    public Member login(String id, String pw) {

    }

    // 회원 목록 조회
    public List<Member> findAllMembers() {

    }

    // 회원 조회
    public Member findMemberById(String id) {
        return memberRepository.selectMemberById(id);
    }

    // 회원 정보 수정
    public int modifyMember(Member member) {
        return memberRepository.updateMember(member);
    }

    // 회원 탈퇴
    public int removeMember(String memberId) {
        return memberRepository.deleteMember(memberId);
    }



}
