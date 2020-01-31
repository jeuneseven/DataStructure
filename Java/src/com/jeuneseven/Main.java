package com.jeuneseven;

import com.jeuneseven.TimeTool.Task;

public class Main {

    /**
     * // O(2^n)
     * 	public static int fib1(int n) {
     * 		if (n <= 1) return n;
     * 		return fib1(n - 1) + fib1(n - 2);
     *        }
     *
     * 	// O(n)
     * 	public static int fib2(int n) {
     * 		if (n <= 1) return n;
     *
     * 		int first = 0;
     * 		int second = 1;
     * 		for (int i = 0; i < n - 1; i++) {
     * 			int sum = first + second;
     * 			first = second;
     * 			second = sum;
     *        }
     * 		return second;
     *    }
     *
     * 	public static void test1(int n) {
     * 		// 汇编指令
     *
     * 		// O(1)
     * 		if (n > 10) {
     * 			System.out.println("n > 10");
     *        } else if (n > 5) { // 2
     * 			System.out.println("n > 5");
     *        } else {
     * 			System.out.println("n <= 5");
     *        }
     *
     * 		// 1 + 4 + 4 + 4 O(1)
     * 		for (int i = 0; i < 4; i++) {
     * 			System.out.println("test");
     *        }
     *
     * 		// 140000
     * 		// O(1)
     * 		// O(1) 空间复杂度
     *    }
     *
     * 	public static void test2(int n) {
     * 		// O(n)
     * 		// 1 + 3n
     * 		for (int i = 0; i < n; i++) {
     * 			System.out.println("test");
     *        }
     *    }
     *
     * 	public static void test3(int n) {
     * 		// 1 + 2n + n * (1 + 3n)
     * 		// 1 + 2n + n + 3n^2
     * 		// 3n^2 + 3n + 1
     * 		// O(n^2)
     *
     * 		// O(n)
     * 		for (int i = 0; i < n; i++) {
     * 			for (int j = 0; j < n; j++) {
     * 				System.out.println("test");
     *            }
     *        }
     *    }
     *
     * 	public static void test4(int n) {
     * 		// 1 + 2n + n * (1 + 45)
     * 		// 1 + 2n + 46n
     * 		// 48n + 1
     * 		// O(n)
     * 		for (int i = 0; i < n; i++) {
     * 			for (int j = 0; j < 15; j++) {
     * 				System.out.println("test");
     *            }
     *        }
     *    }
     *
     * 	public static void test5(int n) {
     * 		// 8 = 2^3
     * 		// 16 = 2^4
     *
     * 		// 3 = log2(8)
     * 		// 4 = log2(16)
     *
     * 		// 执行次数 = log2(n)
     * 		// O(logn)
     * 		while ((n = n / 2) > 0) {
     * 			System.out.println("test");
     *        }
     *    }
     *
     * 	public static void test6(int n) {
     * 		// log5(n)
     * 		// O(logn)
     * 		while ((n = n / 5) > 0) {
     * 			System.out.println("test");
     *        }
     *    }
     *
     * 	public static void test7(int n) {
     * 		// 1 + 2*log2(n) + log2(n) * (1 + 3n)
     *
     * 		// 1 + 3*log2(n) + 2 * nlog2(n)
     * 		// O(nlogn)
     * 		for (int i = 1; i < n; i = i * 2) {
     * 			// 1 + 3n
     * 			for (int j = 0; j < n; j++) {
     * 				System.out.println("test");
     *            }
     *        }
     *    }
     *
     * 	public static void test10(int n) {
     * 		// O(n) 空间复杂度
     * 		int a = 10;
     * 		int b = 20;
     * 		int c = a + b;
     * 		int[] array = new int[n];
     * 		for (int i = 0; i < array.length; i++) {
     * 			System.out.println(array[i] + c);
     *        }
     *    }
     */
    /*
    * 求第N个斐波那契数，方法一
    * O(2^n)
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
     * O(n)
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
    /**
     * 精简版本
     */
    public static int fib3(int n) {
        if (n <= 1){
            return n;
        }

        int first = 0;
        int second = 1;
        while (n-- > 1) {
            second += first;
            first = second - first;
        }

        return second;
    }
    /**
     * 线性代数解法，复杂度O(1)
     */
    public static int fib4(int n) {
        if (n <= 1){
            return n;
        }

        double c = Math.sqrt(5);
        return (int)((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

    public static void main(String[] args) {
        int number = 40;

        //耗时较多
        TimeTool.check("fib1", new Task() {
            @Override
            public void execute() {
                System.out.println(fib1(number));
            }
        });
        //耗时较少
        TimeTool.check("fib2", new Task() {
            @Override
            public void execute() {
                System.out.println(fib2(number));
            }
        });

        System.out.println("Hello World！");

        System.out.println(fib1(0));
        System.out.println(fib1(1));
        //如果数字比较大的话，会造成性能问题
//        System.out.println(fib1(30000));
        //方法二的效率就会高很多
        System.out.println(fib2(64));
        System.out.println("------");
        System.out.println(fib3(64));
        System.out.println(fib4(64));
    }
}
