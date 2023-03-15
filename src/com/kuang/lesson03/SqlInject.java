package com.kuang.lesson03;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * ClassName: SqlInject
 * Package: com.kuang.lesson02
 * Description: sql注入
 *
 * @Date: 2023-03-14 014 16:43
 * @Author: wangkejing
 */
public class SqlInject {
    public static void main(String[] args) {
        login("zhansan", "123456");
//        login(" 'or '1=1", " 'or '1=1");
    }

    //登录
    public static void login(String username, String password) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            //PreparedStatement 防止SQL注入的本质 把传递进来的参数当做字符
            //假设其中存在转义字符 比如说 ‘ 会被直接转义
            String sql = "select * from users where name = ? and password = ?";
            st = conn.prepareStatement(sql);//获得sql执行对象

            st.setString(1, username);
            st.setString(2, password);

            rs = st.executeQuery();

            while (rs.next()) {
                System.out.println("id=" + rs.getInt("id"));
                System.out.println("name=" + rs.getString("name"));
                System.out.println("password=" + rs.getObject("password"));
                System.out.println("email=" + rs.getObject("email"));
                System.out.println("birthday=" + rs.getObject("birthday"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }


}
