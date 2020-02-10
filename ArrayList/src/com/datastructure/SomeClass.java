package com.datastructure;

public class SomeClass {
    private int intValue;
    private double doubleValue;
    private String stringValue;

    @Override
    public  String toString() {
        return "SomeClass [" + "intValue=" + intValue + "doubleValue=" + doubleValue + "stringValue=" + stringValue + "]";
    }

    //析构方法
    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        System.out.println("SomeClass - finalize");
    }
    //重写父类的equals方法
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
