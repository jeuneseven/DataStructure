package com.jeuneseven;

public class Main {

    /*
    * 求第N个斐波那契数，方法一
    * */
    public static int fib1(int n) {
        if (n <= 1){
            return n;
        }

        return fib1(n - 1) + fib1(n - 2);
    }
    /*
     * 求第N个斐波那契数，方法二
     * 0 1 1 2 3 5 8 13 。。。
     * 1 2 3 5 8 13 。。。
     * */
    public static int fib2(int n) {
        if (n <= 1){
            return n;
        }

        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println("Hello World！");

        System.out.println(fib1(0));
        System.out.println(fib1(1));
        //如果数字比较大的话，会造成性能问题
//        System.out.println(fib1(30000));
        //方法二的效率就会高很多
        System.out.println(fib2(64));
    }
}
