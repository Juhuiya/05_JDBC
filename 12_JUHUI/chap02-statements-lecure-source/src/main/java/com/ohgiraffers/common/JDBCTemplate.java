package com.ohgiraffers.common;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {


    public static Connection getConnection() {

        Properties props = new Properties(); // 키,값에 대한 정보가 들어있는 파일 읽어오기
        Connection con = null; // 커넥션 객체를 생성해 연결.

        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            Class.forName(driver); // 메모리 할당해 사용할 준비하는 것.

            con = DriverManager.getConnection(url, props);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    // connection을 닫는 개념은 별도의 메소드로 분리하고 실제 담는 시점은 Service 계층에서 진행
    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if (rset != null) {
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}