package com.kuang.lesson05;

import com.kuang.lesson05.utils.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * ClassName: TestDBCP
 * Package: com.kuang.lesson05
 * Description:
 *
 * @Date: 2023-03-15 015 16:34
 * @Author: wangkejing
 */
public class TestDBCP {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils_DBCP.getConnection();

            //区别
            //使用？占位符代替参数
            String sql = "insert into users(name, password, email, birthday) values(?,?,?,?)";
            st = conn.prepareStatement(sql);//预编译SQL 先写sql 然后不执行

            //手动给参数赋值
            st.setString(1, "小红小明");
            st.setString(2, "123456");
            st.setString(3, "123456@qq.com");
            //注意点 sql.Date 数据列
            //util.Date java new Date().getTime()
            st.setDate(4, new java.sql.Date(new Date().getTime()));

            //执行
            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, rs);
        }

    }
}
