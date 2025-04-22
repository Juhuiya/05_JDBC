package com.ohgiraffers.crud.domain.member.view;

import com.ohgiraffers.crud.domain.member.controller.MemberController;
import com.ohgiraffers.crud.domain.member.dto.Member;

import java.util.List;
import java.util.Scanner;

public class MemberView {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = """
                ============= 회원 관리 프로그램 ===============
                1. 모든 회원 정보 보기
                2. 회원 찾기
                3. 회원 가입
                4. 회원 정보수정
                5. 회원 탈퇴
                9. 프로그램 종료
                메뉴를 선택해주세요 : """;

        while(true) {
            System.out.print(menu);
            int input = sc.nextInt();

            switch (input) {
                case 1 :
                    List<Member> members = new MemberController().selectAllMembers();
                    displayMembers(members);
                    break;
                case 2 :
                    System.out.println("찾을 회원 ID : ");
                    String searchId = sc.next();
                    Member foundMember = new MemberController().selectMemberById(searchId);
                    break;
                case 3 :
                    Member newMember = inputMember();
                    int result = new MemberController().insertMember(newMember);
                    if(result > 0) {
                        System.out.println("회원가입이 완료되었습니다.");
                    } else {
                        System.out.println("회원가입에 실패했습니다.");
                    }
                    break;
                case 4 :

                    break;
                case 5 :

                    break;
                case 9 :
                    System.out.println("프로그램이 종료됩니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    private static Member inputMember() {
    }

    private static void displayMembers(List<Member> members) {
    }
}
