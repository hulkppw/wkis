package com.ising99.wkis.test;

/**
 * Created by vincen on 2016/5/11.
 */
public enum  SingletonEnum {
    INSTANCE;
    private String description = "Enum";
    public String getDescription(){
        return description;
    }
    public void print(){
        System.out.print(INSTANCE.getDescription());
    }

    public static void main(String[] args){
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.print();
    }
}
