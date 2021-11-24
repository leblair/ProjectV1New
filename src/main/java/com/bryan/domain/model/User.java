package com.bryan.domain.model;

import javax.persistence.*;
import java.util.UUID;


@Entity
//corresponde a :
@Table(name = "usertable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID userid;

    public String username;
    public String password;

}

