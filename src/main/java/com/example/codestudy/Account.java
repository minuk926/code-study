package com.example.codestudy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "account") //cascade = CascadeType.PERSIST)
    private Set<Study> studies = new HashSet<>();

    public void addStudy(Study study){
        this.getStudies().add(study);
        study.setAccount(this);
    }

    public void removeStudy(Study study){
        this.getStudies().remove(study);
        study.setAccount(this);
    }
}
