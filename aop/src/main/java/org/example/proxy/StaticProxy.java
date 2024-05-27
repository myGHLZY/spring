package org.example.proxy;

public class StaticProxy implements StudentService{
    @Override
    public void add() {
        System.out.println("add方法");
    }

    @Override
    public void find() {
        System.out.println("find方法");
    }
}
