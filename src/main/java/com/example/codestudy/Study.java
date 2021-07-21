package com.example.codestudy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    //@JoinColumn(name = "user_id")
    private Account account;

}
