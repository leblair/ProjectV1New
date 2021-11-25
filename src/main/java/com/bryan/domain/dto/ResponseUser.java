package com.bryan.domain.dto;

import com.bryan.domain.model.User;

import java.util.List;

public class ResponseUser {

    public List<UserResult> result;

    public ResponseUser(List<UserResult> result){
        this.result = result;
    }
}
