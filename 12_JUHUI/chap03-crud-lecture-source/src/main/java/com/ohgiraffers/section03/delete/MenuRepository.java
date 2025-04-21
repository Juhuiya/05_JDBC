package com.ohgiraffers.section03.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuRepository {

    private final Properties prop;

    public MenuRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/MenuMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /***
     * 메뉴코드를 이용해서 메뉴삭제 기능
     * @param con 연결객체
     * @param menuMenu 삭제할 메뉴코드 번호
     * @return 성공여부
     */
    // 이 메소드를 실행하면 어떤 값을 반환할 건지 생각해서 작성. code니까 int.
    public int deleteMenu(Connection con, int menuMenu) { // service가 호출하는 거임.

        PreparedStatement pstmt = null;

        int result = 0;

        try {
            String sql = prop.getProperty("deleteMenu");
            System.out.println("sql: " + sql);
            pstmt = con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}
