package com.ising99.wkis.test;

/**
 * Created by vincen on 2016/5/20.
 */
public class CreateObject implements Cloneable{
    CreateObject object = null;
    public CreateObject(){
        try {
            object = (CreateObject)Class.forName("com.ising99.wkis.test.CreateObject").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
