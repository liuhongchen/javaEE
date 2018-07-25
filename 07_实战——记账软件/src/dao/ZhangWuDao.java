package dao;

import domain.ZhangWu;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tools.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ZhangWuDao {
    QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
    public List<ZhangWu> selectAll() throws SQLException {
        String sql="select * from gjp_zhangwu";
        return queryRunner.query(JDBCUtils.getDataSource().getConnection(),sql,new BeanListHandler<ZhangWu>(ZhangWu.class));
    }
}
