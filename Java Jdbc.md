# Java JDBC
> JDBC（Java Database Connectivity），是 Java 为关系型数据库定义的一套标准的访问接口，是 Java 程序访问关系型数据库的标准接口

## 基础概念

### JDBC 和 JDBC 驱动

JDBC 是一套接口，属于抽象，JDBC 驱动一般指的是具体某种数据库的 JDBC 驱动，是对 JDBC 接口的具体实现，两者之间是抽象和具体的关系（也可称为类与对象的关系）

## JDBC 接口的使用

### 基本使用步骤

1. 提供具体的 JDBC 驱动（jar包）到项目的 classpath 中（DriverManager 会自动扫描并注册）
2. 提供数据库连接时的 url、username、password ，使用 DriverManager.getConnection() 返回一个 Connection 对象（数据库连接对象）
3. 使用 connection.CreateStatement() 创建一个 Statement 对象（静态 SQL 语句执行对象）；使用 connection.prepareStatement() 创建一个 PrepareStatement 对象（预编译模板 SQL 语句执行对象）
4. 使用 Statement 对象的 executeQuery() 或 executeUpdate() 方法来执行查询语句或增删改语句
5. 得到结果集 ResultSet ，对 ResultSet 对象进行数据读取

### JDBC 事务

> 默认情况下，获取到 Connection 连接后，总是处于“自动提交”模式，也就是每执行一条 SQL 都是作为事务自动执行的

```java
Connection conn = openConnection();
try {
    // 关闭自动提交:
    conn.setAutoCommit(false);
    // 执行多条SQL语句:
    insert(); update(); delete();
    // 提交事务:
    conn.commit();
} catch (SQLException e) {
    // 回滚事务:
    conn.rollback();
} finally {
    conn.setAutoCommit(true);
    conn.close();
}
```

### 批量执行

> 适用于 PrepareStatement 对象

```java
prepareStatement.addBatch()
prepareStatement.executeBatch()
```

### 数据库连接池

JDBC 连接池有一个标准的接口 `javax.sql.DataSource`，注意这个类位于 Java 标准库中，但仅仅是接口。要使用 JDBC 连接池，我们必须选择一个 JDBC 连接池的实现。常用的 JDBC 连接池有：

+ HikariCP
+ C3P0
+ BoneCP
+ Druid

使用方式：
1. 不是直接使用 DriverManager.getConnection 获取 Connection 对象；
2. 而是首先创建一个 DataSource 具体对象，然后根据 dataSource.getConnection 获取 Connection 对象；