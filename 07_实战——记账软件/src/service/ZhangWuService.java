package service;

import dao.ZhangWuDao;
import domain.ZhangWu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZhangWuService {
    private ZhangWuDao zhangWuDao=new ZhangWuDao();

    public  List<ZhangWu> selectAll() throws SQLException {
        return zhangWuDao.selectAll();
    }
}
