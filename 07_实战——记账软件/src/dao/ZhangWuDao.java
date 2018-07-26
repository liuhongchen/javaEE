package dao;

import domain.ZhangWu;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tools.JDBCUtils;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ZhangWuDao {
    QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
    public List<ZhangWu> selectAll() throws SQLException {
        String sql="select * from gjp_zhangwu";
        return queryRunner.query(JDBCUtils.getDataSource().getConnection(),sql,new BeanListHandler<ZhangWu>(ZhangWu.class));
    }

    public List<ZhangWu> selectByDateScope(String  beginTime, String endTime) throws SQLException {
        String sql="select * from gjp_zhangwu where createtime between ? and ?";
        return queryRunner.query(JDBCUtils.getDataSource().getConnection(),sql,
                new BeanListHandler<ZhangWu>(ZhangWu.class),beginTime,endTime);
    }

    public int addZhangWu(String flname, Double money, String zhanghu, String createtime, String description) throws SQLException {
        String sql="insert into gjp_zhangwu values (?,?,?,?,?,?)";
        return queryRunner.update(JDBCUtils.getDataSource().getConnection(),sql,
                null,flname,money,zhanghu,createtime,description);
    }
}
