package com.ranchat.dto;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private String name;
    private List<User> users;

    public Chat(String name) {
        this.name = name;
        users = new ArrayList<User>();
    }
}
