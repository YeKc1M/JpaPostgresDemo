package com.example.postgresdemo;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Service
public class FakePersonService {
    Connection connection;

    public FakePersonService(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public","postgres","password");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Person save(Person person){
        try{
            Statement statement = connection.createStatement();
            String sql = "insert into person values (" + person.getId() + ", \'" + person.getName() + "\');";
            System.out.println(sql);
            statement.execute(sql);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return person;
    }
}
