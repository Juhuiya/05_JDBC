package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {

        Connection con = getConnection();

        // PreparedStatement 객체의 타입은 PreparedStatement 타입이면서
        // Statement 타입이기도 하다. => 상속 구조이기 때문이고, 그래서 다형성을 적용할 수 ㅇ.
        // close(pstmt) ==> Close(Statement stmt = new PreparedStatement타입)
        // Close(Statement stmt = new PreparedStatement타입)은 부모타입으로 받아서 up-casting
        PreparedStatement pstmt = null;
        ResultSet rset = null; // 조회를 해서 조회된 결과값을 받아오려고 하는 것임. 행 단위로 들고올때 Result Set타입을 써줌

        try {
            pstmt = con.prepareStatement("SELECT MENU_NAME, MENU_PRICE FROM tbl_menu");
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.printf("%s %d\n", rset.getString("MENU_NAME"),rset.getInt("MENU_PRICE"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
