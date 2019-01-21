package com.itmayiedu;

public enum singleton1 {
    INSTANCE;
    private singleton1(){
        System.out.println("枚举单例实例化了-------------------");
    }
    public void fun1(){
        System.out.println("我是enum单例");
    }
}
