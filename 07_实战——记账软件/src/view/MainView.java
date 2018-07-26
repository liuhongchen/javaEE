package view;

import domain.ZhangWu;
import service.ZhangWuService;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
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

    private void addZhangWu() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入账务名称：");
        String flname =sc.nextLine();
        System.out.println("请输入消费金额：");
        Double money =sc.nextDouble();
        sc.nextLine();
        System.out.println("请输入支付方式（现金或银行名称）：");
        String zhanghu =sc.nextLine();
        Calendar calendar=Calendar.getInstance();
        String createtime =calendar.get(Calendar.YEAR)+"-"
                +calendar.get(Calendar.MONTH)+"-"
                +calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("请输入账务描述：");
        String description =sc.nextLine();

        int result=zhangWuService.addZhangWu(flname,money,zhanghu,createtime,description);
        if(result==0){
            System.out.println("添加失败！");
            addZhangWu();
        }else {
            System.out.println("添加成功！");
        }
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
                    selectByDateScope();
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }

    private void selectByDateScope() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入开始时间：");
        String beginTime=sc.nextLine();
        System.out.println("请输入结束时间：");
        String endTime=sc.nextLine();
        List<ZhangWu> zhangWuList =zhangWuService.selectByDateScope(beginTime,endTime);

        for(ZhangWu zhangWu:zhangWuList){
            System.out.println(zhangWu);
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
