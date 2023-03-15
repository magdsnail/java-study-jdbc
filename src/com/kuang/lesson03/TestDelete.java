package com.kuang.lesson03;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * ClassName: TestDelete
 * Package: com.kuang.lesson03
 * Description:
 *
 * @Date: 2023-03-15 015 11:25
 * @Author: wangkejing
 */
public class TestDelete {
    public static void main(String[] args) {


        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();

            //区别
            //使用？占位符代替参数
            String sql = "delete from users where id = ?";
            st = conn.prepareStatement(sql);//预编译SQL 先写sql 然后不执行

            //手动给参数赋值
            st.setInt(1, 4);

            //执行
            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功");
            }


        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }

    }
}
