import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class QueryRunnerDemo {

    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCUtils.getConnection();
        String sql="select * from sort";
//        Object[] objs=queryRunner.query(con,sql,new ArrayHandler());
//        List<Object[]> arr=queryRunner.query(con,sql,new ArrayListHandler());
//        for(Object[] objs:arr){
//            for(Object obj:objs){
//                System.out.println(obj);
//            }
//            System.out.println();
//            System.out.println();
//        }
//        Sort sort=queryRunner.query(con,sql, new BeanHandler<Sort>(Sort.class));
//        System.out.println(sort);

//        List<Sort> sorts=queryRunner.query(con,sql,new BeanListHandler<Sort>(Sort.class));
//        for(Sort sort:sorts){
//            System.out.println(sort);
//        }

//        List<String> strArr =queryRunner.query(con,sql,
//                new ColumnListHandler<>("sname"));
//
//        for(String s:strArr){
//            System.out.println(s);
//        }

//        Map<String,Object> map=queryRunner.query(con,sql,new MapHandler());
//
//        for(String s:map.keySet()){
//            System.out.println(s+" "+map.get(s));
//        }

        List<Map<String,Object>> maps=queryRunner.query(con,sql,new MapListHandler());

        for(Map<String,Object> map:maps){
            for(String s:map.keySet()){
                System.out.println(s+": "+map.get(s));
            }
        }
    }
}
