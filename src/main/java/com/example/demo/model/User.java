package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    public User(String name, String email, String password) {
        this.id = 0l;
        this.name = name;
        this.email = email;
        this.password = password;
        this.lectures = new ArrayList<>();
    }

    public User() {
        this.lectures = new ArrayList<>();
    }

    public User(Long id, String name, String email, String password, List<Lecture> users) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.lectures = users;
    }


    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

    private int department;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Lecture> lectures;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", department=" + department +
                ", users=" + lectures +
                '}';
    }
}
