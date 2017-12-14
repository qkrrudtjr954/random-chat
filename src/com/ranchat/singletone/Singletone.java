package com.ranchat.singletone;

import com.ranchat.dto.Chat;
import com.ranchat.dto.User;

import java.util.ArrayList;
import java.util.List;

public class Singletone {
    private static Singletone instance = null;
    private User current_user = null;
    private List<User> users;
    private List<Chat> chats;

    private Singletone(){
        this.users = new ArrayList<User>();
        this.chats = new ArrayList<Chat>();
    }
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

    public User getCurrentUser(){ return this.current_user; }

    public void setCurrentUser(User user){ this.current_user = user; }

    public void addUser(User user){ this.users.add(user); }
}
