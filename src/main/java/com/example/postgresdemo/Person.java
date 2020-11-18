package com.example.postgresdemo;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Person {
    @Id
    @NotNull
    private int id;

    @NotNull
    private String name;

    public Person(int id, String name){
        this.setId(id);
        this.setName(name);
    }

    public Person(){}
}
