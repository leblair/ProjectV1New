package com.bryan.domain.dto;

import com.bryan.domain.model.User;

import java.util.List;

public class ResponseUser {

    public List<User> result;

    public ResponseUser(List<User> result){
        this.result = result;
    }
}
