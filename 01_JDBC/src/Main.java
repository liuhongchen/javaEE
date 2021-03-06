import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;
/*
1.概述：
    JDBC是一种用于执行SQL语句的java API，可以为多种关系数据库提供统一访问，它由一组用。
    java语言编写的类和接口组成。是java 访问数据库的标准规范。

    JDBC提供了一种基准，据此可以构建更高级的工具和接口，使数据库开发人员能够编写数据库。

    JDBC需要链接驱动，驱动使两个设备要进行通信，满足一定通信数据格式，数据格式由设备提供商规定，设备提供商为设备提供驱动软件，通过软件可以于该设备进行通信。

2.JDBC开发步骤
    注册驱动
        告知JVM使用的使哪一个数据库的驱动，是mysql还是Oracle
    获得连接
        使用JDBC中的类，完成对MySQL数据库的连接
    获得语句执行平台
        通过连接对象获取对SQL语句的执行者对象
    执行sql语句
        使用执行者对象，向数据库执行SQL语句
        获取数据库的执行后的结果集
    处理结果

    释放资源
        调用一堆关闭方法（）


３.注册驱动
    方式1：//这样会注册两次，造成资源浪费
    使用java.sql.DriverManager类静态方法registerDriver()
    Driver是个接口
    传入的是导入的jar包中的com.mysql.jdbc.Driver;
    方式2（推荐）：//使用反射
    Class.forname(“类的全名”）；
    Class.forname("com.mysql.jdbc.Driver")

4.获得数据库的连接
    DriverManager中的静态方法 getConnection（String url，String user，String password）
    返回值是connection接口的实现类，在mysql的驱动程序中
    url是数据库的连接地址，固定写法：
        jdbc：mysql（这是数据库的类型）：mysql：//连接主机IP：端口号//数据库名字

    如果出现ERROR: The server time zone value
        则在数据库名后面加上?serverTimezone=UTC

5.获取sql语句的执行者对象
    Connection对象调用方法 Statement createStatement()获取Statement对象用于将
    sql语句发送到数据库
    返回值是Statement接口的实现类对象，在mysql驱动中
    Statement的作用是发送sql语句，并返回执行的结果集

    但是Statement容易被注入攻击，所以用其子接口PreparedStatement
    其实现类也在mysql的驱动中
    所以调用connection的preparedStatement方法
    使用该方法后，sql语句中的参数全部使用占位符？
    然后用setXX方法设置第几个问号对应的变量
    例如setObject(第几个问号的位置,java变量名）
    在使用update的语句的时候，sql语句也使用占位符


    int executeUpdate(String sql) 执行数据库中SQL语句，
    但是 只能执行insert delete update
    其中int返回的是有多少行受影响

    ResultSet executeQuery(String sql) 返回单个ResultSet对象
    返回值ResultSet接口实现类对象，实现类在mysql驱动中

6.处理结果集
    ResultSet接口方法 boolean next()返回true则有结果集否则没有结果集
    while(rs.next()){
        语句。
    }
    获取每列的数据，使用的是ResultSet接口的方法getXX()
    getInt() 参数可以是第几列或者是列名，列数从1开始
    getString()
    getDouble()
    这些getXX的XX指的是在ResultSet中存储的格式

    偷懒的话，就是getObject()
7.释放资源
    con.close();
    statement.close();
    rs.close();


8.SQL的注入攻击（登录案例）
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        //驱动注册,这样会注册两次
////        DriverManager.registerDriver(new Driver());
//        Class.forName("com.mysql.jdbc.Driver");
//
//        //获得数据库的连接
//        Connection con=DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/db?serverTimezone=UTC",
//                "root","123456");
//        System.out.println(con);
//
//        //获取sql语句的执行者对象。
//        Statement statement= con.createStatement();
//
//        //执行增删改语句
////            int row =statement.executeUpdate(
////                    "insert into sort values (null,'汽车用品',50000,'疯狂涨价')"
////            );
////            System.out.println(row);
//
//        //执行查询语句
//        ResultSet resultSet=statement.executeQuery(
//                "select * from sort"
//        );
//
//        //处理查询语句的结果
//
//        //释放资源
//        con.close();
//        statement.close();




//        //1.驱动注册
//        Class.forName("com.mysql.jdbc.Driver");
//
//        //2.获得连接
//        Connection con=DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/db?serverTimezone=UTC",
//                "root",
//                "123456");
//
//        //3.获得sql执行者对象
//        Statement stat=con.createStatement();
//        使用更安全的方式
//        PreparedStatement pStat=con.preparedStatement();
//
//        //4.执行语句
//        stat.executeUpdate(
//                "delete from sort where sid=3"
//        );
//
//        ResultSet rs=stat.executeQuery(
//                "select * from sort"
//        );
//
//        //5.处理结果集
//        while(rs.next()){
//            System.out.println(rs.getString("sname"));
//        }
//
//        //6.释放资源
//        con.close();
//        stat.close();
//        rs.close();


    //注入攻击（登录案例）

    //preparedStatement
        Scanner sc=new Scanner(System.in);
        String usname=sc.nextLine();
        String psword=sc.nextLine();

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db?serverTimezone",
                "root",
                "123456"
        );


        String sql="select * from users where username =? and password=?";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setObject(1,usname);
        pst.setObject(2,psword);

    }
}
