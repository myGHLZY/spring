package org.example.pojo;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private String name;
    private Integer age;
    private String[] hobby;
    private City city;

}
