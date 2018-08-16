package todo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int i=0;
        Scanner sc=new Scanner(System.in);
        while(++i>0){
            System.out.println(i+"please input todo item name");
            TodoItem item=new TodoItem(sc.nextLine());
            System.out.println(item);
        }
    }
}
