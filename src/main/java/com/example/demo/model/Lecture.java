package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lectures")
@Getter
@Setter
public class Lecture {
    public Lecture() {
        this.participants = new ArrayList<>();
    }

    public Lecture(Long id, String name) {
        this.id = id;
        this.name = name;
        this.participants = new ArrayList<>();
    }

    public Lecture(String name) {
        this.id = 0l;
        this.name = name;
        this.participants = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> participants;

}
