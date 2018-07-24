import javax.xml.transform.Result;
import java.sql.*;

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

    }
}
