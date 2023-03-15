package com.kuang.lesson05.utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ClassName: JdbcUtils
 * Package: com.kuang.lesson02.utils
 * Description:
 *
 * @Date: 2023-03-14 014 15:21
 * @Author: wangkejing
 */
public class JdbcUtils_C3P0 {

//    private static DataSource dataSource = null;
    private static ComboPooledDataSource dataSource = null;

    static {
        try {
//            dataSource = new ComboPooledDataSource();
//            dataSource.setDriverClass();
//            dataSource.setJdbcUrl();
//            dataSource.setUser();
//            dataSource.setPassword();
//            dataSource.setMaxPoolSize();
//            dataSource.setMinPoolSize();

            //创建数据源 工厂模式 --> 创建
            dataSource = new ComboPooledDataSource();//配置文件写法

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //释放资源
    public static void release(Connection conn, Statement st, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }





















}
