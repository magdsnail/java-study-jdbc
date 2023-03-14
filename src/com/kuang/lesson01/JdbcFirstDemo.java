package com.kuang.lesson01;

import java.sql.*;

/**
 * ClassName: lesson01
 * Package: com.kuang
 * Description:我的第一个jdbc程序
 *
 * @Date: 2023-03-14 014 11:42
 * @Author: wangkejing
 */
public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");//固定写法加载驱动
        //2.用户信息和url
        //userUnicode=true&characterEncoding=utf8&useSSL=true
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?userUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=false";
        String username = "root";
        String password = "123456";
        //3.连接成功 数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);
        //4.执行SQL的对象
        Statement statement = connection.createStatement();
        //5.执行SQL的对象 去 执行SQL 可能存在结果 查看返回结果
        String sql = "select * from users";

        //statement.executeQuery();//查询操作 返回 ResultSet
        //statement.execute();//执行任何SQL
        //statement.executeUpdate();//更新 插入 删除 都是用这个 返回一个受影响的行数

        ResultSet resultSet = statement.executeQuery(sql);//返回的结果集

        //resultSet.getObject();//在不知道列类型的时候使用
        //如果知道类型
       /* resultSet.getInt();
        resultSet.getString();
        resultSet.getDouble();
        resultSet.getFloat();
        resultSet.getBoolean();*/

        //resultSet.beforeFirst();//移动到最前面
        //resultSet.afterLast();//移动到最后面
        //resultSet.next();//移动到下一个数据
        //resultSet.previous();//移动到前一行
        //resultSet.absolute(row);//移动到指定行

        while (resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
            System.out.println("================================");
        }


        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
