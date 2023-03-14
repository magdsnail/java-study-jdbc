package com.kuang.lesson02;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ClassName: TestInsert
 * Package: com.kuang.lesson02.utils
 * Description:
 *
 * @Date: 2023-03-14 014 15:51
 * @Author: wangkejing
 */
public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得sql执行对象
            String sql = "insert into users(name, password, email, birthday) values('xiaoming', '123456', '123@11.com','1993-02-09')";
            int i = st.executeUpdate(sql);
            System.out.println("=============" + i);

            if (i > 0) {
                System.out.println("插入成功");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
