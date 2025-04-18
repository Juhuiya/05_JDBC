package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {

    public static void main(String[] args) {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306"
                    ,"ohgiraffers","ohgiraffers"); // 커넥션 객체가 잘 생성되었는지 확인
            System.out.println("con = " + con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
