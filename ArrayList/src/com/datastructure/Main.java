package com.datastructure;
import com.datastructure.ArrayList;
public class Main {
    public static void main(String[] args) {
        //向堆空间申请内存
        ArrayList <Integer> arrayList = new ArrayList<>();
        //分配的内存空间中，存储的是每个元素的地址，而非元素真正内存
        ArrayList <SomeClass> objectList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);

//        arrayList.remove(1);
        arrayList.add(0, 100);


        System.out.println(arrayList.toString());
    }
}
