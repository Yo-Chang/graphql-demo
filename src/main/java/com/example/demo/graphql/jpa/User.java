package com.example.demo.graphql.jpa;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String name;

    private Integer age;

    private Float height;

    private Float weight;

    private String birthDay;
}
