package com.kuang.lesson03;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: TestQuery
 * Package: com.kuang.lesson03
 * Description:
 *
 * @Date: 2023-03-15 015 11:33
 * @Author: wangkejing
 */
public class TestQuery {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from users where id = ?";
            st = conn.prepareStatement(sql);

            st.setInt(1, 1);

            rs = st.executeQuery();

            while (rs.next()){
                System.out.println("name = " + rs.getObject("name"));
                System.out.println("password = " + rs.getObject("password"));
                System.out.println("email = " + rs.getObject("email"));
                System.out.println("birthday = " + rs.getObject("birthday"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }


    }
}
