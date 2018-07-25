package view;

import domain.ZhangWu;
import service.ZhangWuService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainView {
    private ZhangWuService zhangWuService = new ZhangWuService();

    public void run() throws SQLException {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println("----------------------------记账软件----------------------------");
            System.out.println(" 1.添加账务   2.编辑账务   3.删除账务   4.查询账务   5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");

            int op = sc.nextInt();
            switch (op) {
                case 1:
                    addZhangWu();
                    flag = false;
                    break;
                case 2:
                    editZhangWu();
                    flag = false;
                    break;
                case 3:
                    deleteZhangWu();
                    flag = false;
                    break;
                case 4:
                    selectZhangWu();
                    flag = false;
                    break;
                case 5:
                    System.out.println("再见！");
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }

    private void addZhangWu() {

    }

    private void editZhangWu() {
    }

    private void deleteZhangWu() {
    }

    private void selectZhangWu() throws SQLException {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println("1.查询所有  2.按条件查询");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    selectAll();
                    flag = false;
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }


    private void selectAll() throws SQLException {
        List<ZhangWu> zhangWuList = zhangWuService.selectAll();
        if (zhangWuList != null) {
            for (ZhangWu zhangWu : zhangWuList) {
                System.out.println(zhangWu);
            }
        } else {
            System.out.println("null");
        }
    }


}
