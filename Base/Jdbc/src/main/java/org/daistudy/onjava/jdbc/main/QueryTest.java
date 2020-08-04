package org.daistudy.onjava.jdbc.main;

import java.sql.*;
import java.util.Date;

public class QueryTest {
    public static void main(String[] args) {
        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://10.177.97.180:1433; DatabaseName = plp_private";
            String username = "sqluser";
            String password = "123456!a";
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (Statement statement = connection.createStatement()) {
                    // 执行 sql 语句
                    String sql = null;

                    // 一个数据
                    System.out.println("一个数据");
                    sql = "select count(*) as total from test_stu";

                    // ResultSet 也需要关闭资源
                    try (ResultSet resultSet1 = statement.executeQuery(sql)) {

                        while (resultSet1.next()) {
                            final int total = resultSet1.getInt("total");
                            System.out.println("total = " + total);
                        }
                    }

                    // 一行数据
                    System.out.println("一行数据");
                    sql = "select * from test_stu where id = 1";
                    try (ResultSet resultSet2 = statement.executeQuery(sql)) {
                        while (resultSet2.next()) {
                            // ResultSet获取列时，索引从1开始而不是0
                            final int id = resultSet2.getInt("id");
                            final String name = resultSet2.getString("name");
                            final int age = resultSet2.getInt("age");
                            final Date date = resultSet2.getDate("date");
                            System.out.println("id = " + id + ", name = " + name + ", age = " + age + ", date = " + date);
                        }
                    }

                    // 多行数据
                    System.out.println("多行数据");
                    sql = "select * from test_stu";
                    try (ResultSet resultSet3 = statement.executeQuery(sql)) {
                        while (resultSet3.next()) {
                            final int id = resultSet3.getInt("id");
                            final String name = resultSet3.getString("name");
                            final int age = resultSet3.getInt("age");
                            final Date date = resultSet3.getDate("date");
                            System.out.println("id = " + id + ", name = " + name + ", age = " + age + ", date = " + date);
                        }
                    }
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
