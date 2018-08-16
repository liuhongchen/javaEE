package demo01;

public class OrderDao {
    public void save(){
        System.out.println("保存");
    }
    public void delete(){
        System.out.println("删除");
    }
    public String update(){
        System.out.println("修改");
        return "AfterReturning";
    }
    public void find(){
        System.out.println("查找");
        int i=1/0;
        System.out.println(i);
    }
}
