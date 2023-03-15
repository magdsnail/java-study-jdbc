package com.kuang.lesson04;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: TestTransaction1
 * Package: com.kuang.lesson04
 * Description:
 *
 * @Date: 2023-03-15 015 14:15
 * @Author: wangkejing
 */
public class TestTransaction1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            //关闭数据库的自动提交 自动会开启事务
            conn.setAutoCommit(false);//开启事务

            String sql1 = "update account set money = money - 100 where name = 'A'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            int x = 1 / 0;//报错

            String sql2 = "update account set money = money + 100 where name = 'B'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            //业务完毕 提交事务
            conn.commit();
            System.out.println("成功");

        } catch (SQLException e) {
//            try {
//                conn.rollback();//如果失败则回滚事务
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }


    }
}
