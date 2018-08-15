package spring.demo01;
/*
* 用户管理业务层接口实现类
* */
public class UserServiceImpl implements UserService{
    @Override
    public void save() {
        System.out.println("UserService执行了。。。");
    }
}
