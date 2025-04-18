package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    /* 메뉴코드를 입력받아서 하나의 메뉴를 조회하는 기능 */
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null; // 결과값 받기 위해서 ResultSet

        try {
            stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("메뉴코드를 입력하세요 : ");
            int menuCode = sc.nextInt();

            String query = "select * from tbl_menu where menu_code = " + menuCode;
            //String query = "select * from menu where menu_name = " + menuName + "'"; //'(따옴표 넣어줘야함), 문자열인 쿼리를 가져올 때
            System.out.println("query : " + query);

            rset = stmt.executeQuery(query);
            if(rset.next()) {
                System.out.print(rset.getString("menu_name") + " " + rset.getInt("menu_price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
