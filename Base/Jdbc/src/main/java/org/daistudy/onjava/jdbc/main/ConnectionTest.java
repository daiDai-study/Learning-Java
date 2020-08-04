package org.daistudy.onjava.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1、加载驱动
        // 把com.mysql.jdbc.Driver/com.microsoft.sqlserver.jdbc.SQLServerDriver这份字节码加载进JVM
        // 当一份字节码加载进JVM的时候，就会执行字节码文件中的静态代码块
        // 静态代码块中会进行  DriverManager.registerDriver(mssqlDriver) 去实例化并注册一个驱动器
        // DriverManager会自动扫描classpath，找到所有的JDBC驱动
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // 2、连接
        String url = "jdbc:sqlserver://10.177.97.180:1433; DatabaseName=plp_private";
        String username = "sqluser";
        String password = "123456!a";

        // 减线连接时，会根据我们传入的URL自动挑选一个合适的驱动
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            // 3、验证连接
            System.out.println(connection); // 如果有输出，表明连接成功

            // 4、创建sql语句
            String sql = "create table test_stu (id int , name varchar(20), age int)";

            // 5、执行sql语句
            try (Statement st = connection.createStatement()) {
                int row = st.executeUpdate(sql);
                System.out.println("row = " + row);

                // 6、释放
                st.close();
            }
            connection.close();
        }
    }
}
