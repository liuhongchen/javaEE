public class HelloWorld22 {

    //定义静态变量score1 score2
    static int score1 = 73;
    static int score2 = 77;
    //定义静态方法sum 并返回成绩总分
    public static int sum() {
        return score1 + score2;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //调用静态方法sum并接受返回值
//        int allScore = HelloWorld22.sum();
//        System.out.println("成绩总分为："+allScore);
        HelloWorld.print();
        System.out.println("-----------------");
        HelloWorld hello=new HelloWorld();
        hello.show();
    }

}