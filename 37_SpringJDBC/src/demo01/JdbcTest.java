package demo01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTest {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test01(){
        jdbcTemplate.update("insert into  account values (null ,?,?)","haha",1000000d);

    }

    @Test
    public void query(){
        Object account=jdbcTemplate.queryForObject("select * from account where id=?",new MyRowMapper(),1);
        System.out.println(account);
    }

    class MyRowMapper implements RowMapper{

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account=new Account();
            account.setId(resultSet.getInt("id"));
            account.setName(resultSet.getString("name"));
            account.setSalary(resultSet.getDouble("salary"));
            return account;
        }
    }
}
