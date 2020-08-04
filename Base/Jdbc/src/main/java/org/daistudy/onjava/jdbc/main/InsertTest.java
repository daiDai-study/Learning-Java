package org.daistudy.onjava.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
    public static void main(String[] args) {
        try{
            // 加载驱动器，DriverManager 会自动加载，下面代码可以注释
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // 建立数据库连接
            String url = "jdbc:sqlserver://10.177.97.180:1433; DatabaseName=plp_private";
            String username = "sqluser";
            String password = "123456!a";
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                // 创建执行器
                try (Statement statement = connection.createStatement()) {

                    int row;
                    // 执行插入语句
                    String sql = "insert into test_stu values(4, 'hhh', 26)";
                    row = statement.executeUpdate(sql);
                    System.out.println(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
