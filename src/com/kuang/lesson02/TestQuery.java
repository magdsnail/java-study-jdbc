package com.kuang.lesson02;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ClassName: TestQuery
 * Package: com.kuang.lesson02
 * Description:
 *
 * @Date: 2023-03-14 014 16:36
 * @Author: wangkejing
 */
public class TestQuery {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得sql执行对象
            String sql = "select * from users where id = 1";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id="+rs.getInt("id"));
                System.out.println("name="+rs.getString("name"));
                System.out.println("password="+rs.getObject("password"));
                System.out.println("email="+rs.getObject("email"));
                System.out.println("birthday="+rs.getObject("birthday"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
