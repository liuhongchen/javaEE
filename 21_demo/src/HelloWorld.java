
public class HelloWorld {
    String name = "爱慕课！";//非静态变量name
    static String hobby = "imooc!";//静态变量hobby

    //静态方法调用非静态变量
    public static void print() {
        HelloWorld hello = new HelloWorld();
        System.out.println("欢迎您："+hello.name+"!");
        System.out.println("兴趣："+hobby+"!");
    }

    //普通方法可以直接调用非静态和静态变量
    public void show() {
        System.out.println("欢迎您："+name+"!");
        System.out.println("兴趣："+hobby+"!");

    }
}