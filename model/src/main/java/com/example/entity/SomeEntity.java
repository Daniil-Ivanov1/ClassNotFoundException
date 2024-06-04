package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SomeEntity {
    @Id
    private String id;
    private String entityField;
}
