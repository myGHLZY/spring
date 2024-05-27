package org.example.proxy;

import lombok.Data;

@Data
public class Student implements StudentService{
    private String name;
    private Integer age;

    @Override
    public void add() {

    }

    @Override
    public void find() {

    }
}

