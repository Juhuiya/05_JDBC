package com.ohgiraffers.crud.domain.member.repository;

import com.ohgiraffers.crud.domain.member.dto.Department;
import com.ohgiraffers.crud.domain.member.dto.Member;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.crud.common.JDBCTemplate.close;

public class MemberRepository {

    private Properties prop = null;

    public MemberRepository() {

        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/MemberMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 회원 전체 조회
    public List<Member> selectAllMembers(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectAllMembers");
        System.out.println("sql = " + sql);

        List<Member> members = null;
        try {
            pstmt = con.prepareStatement(sql);

            rset = pstmt.executeQuery();
            members = new ArrayList<>();
            while(rset.next()) {
                Member member = new Member();
                member.setEmpId(rset.getString("emp_id"));
                member.setEmpName(rset.getString("emp_name"));
                member.setEmpNo(rset.getString("emp_no"));

                Department department = new Department();
                department.setDeptID(rset.getString("dept_id"));
                department.setDeptTitle(rset.getString("dept_title"));
                member.setDept(department);
                members.add(member);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(rset);
        }

        return members;
    }

    // 회원 추가
    public int insertMember(Connection con, Member member) {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = prop.getProperty("insertMember");

        try {
            pstmt = con.prepareStatement(sql);

            // 필요한 값들을 설정
            pstmt.setString(1, member.getEmpId());
            pstmt.setString(2, member.getEmpName());
            pstmt.setString(3, member.getEmpNo());
            pstmt.setString(4, member.getDept().getDeptTitle());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // 회원 ID로 조회
    public Member selectMemberById(int id) {

    }

    // 회원 정보 수정
    public int updateMember(Member member) {

    }

    // 회원 탈퇴
    public int deleteMember(String memberId) {

    }
}
