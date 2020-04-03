package com.zrdh.utils;

import java.sql.*;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/30 17:08
 */
public class JDBCUtil {
    // 定义静态变量，使用静态代码获取配置文件的值
    private static String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
    private static String user = "root";
    private static String password = "root";
    private static String driver = "com.mysql.jdbc.Driver";
    /*// 使用静态代码注册驱动并给静态变量赋值
    static{
        try {
            // 创建Properties集合类
            Properties pro = new Properties();
            // 获取src路径下文件，使用ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            // URL定位了文件的绝对路径
            URL res = classLoader.getResource("jdbc.properties");
            // 获取字符串路径
            String path = res.getPath();
            // 读取文件
            pro.load(new FileReader(path));
            // 给静态变量赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            // 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Statement stmt, Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
