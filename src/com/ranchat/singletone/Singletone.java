package com.ranchat.singletone;

import com.example.dto.Chat;
import com.example.dto.User;

import java.util.List;

public class Singletone {
    private static Singletone instance = null;
    private List<User> users;
    private List<Chat> chats;

    public static Singletone getInstance() {
        if(instance == null){
            instance = new Singletone();
        }
        return instance;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
