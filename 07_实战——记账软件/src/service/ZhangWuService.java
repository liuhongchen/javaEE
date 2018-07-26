package service;

import dao.ZhangWuDao;
import domain.ZhangWu;

import java.sql.SQLException;
import java.util.List;

public class ZhangWuService {
    private ZhangWuDao zhangWuDao=new ZhangWuDao();

    public  List<ZhangWu> selectAll() throws SQLException {
        return zhangWuDao.selectAll();
    }

    public List<ZhangWu> selectByDateScope(String beginTime,String endTime) throws SQLException {
        String s1=beginTime.substring(0,4)
                +beginTime.substring(4,6)
                +beginTime.substring(6);
        String s2=endTime.substring(0,4)
                +endTime.substring(4,6)
                +endTime.substring(6);
        return zhangWuDao.selectByDateScope(s1,s2);
    }

    public int addZhangWu(String flname, Double money, String zhanghu, String createtime, String description) throws SQLException {
        return zhangWuDao.addZhangWu(flname,money,zhanghu,createtime,description);
    }
}
