package com.example.postgresdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table
@IdClass(PK.class)
public class MultiPK {

    @Id
    private int id1;

    @Id
    private int id2;

    private int name;
}

@Data
@NoArgsConstructor
class PK implements Serializable {

    private int id1;

    private int id2;
}
