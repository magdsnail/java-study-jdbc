package com.kuang.lesson02;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ClassName: TestDelete
 * Package: com.kuang.lesson02
 * Description:
 *
 * @Date: 2023-03-14 014 16:32
 * @Author: wangkejing
 */
public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得sql执行对象
            String sql = "delete from users where id = 5";
            int i = st.executeUpdate(sql);
            System.out.println("=============" + i);

            if (i > 0) {
                System.out.println("删除成功");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
