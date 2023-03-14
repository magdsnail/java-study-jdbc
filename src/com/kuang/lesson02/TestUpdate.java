package com.kuang.lesson02;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ClassName: TestUpdate
 * Package: com.kuang.lesson02
 * Description:
 *
 * @Date: 2023-03-14 014 16:33
 * @Author: wangkejing
 */
public class TestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得sql执行对象
            String sql = "update users set name = 'xiaowang' where id = 4";
            int i = st.executeUpdate(sql);
            System.out.println("=============" + i);

            if (i > 0) {
                System.out.println("更新成功");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
