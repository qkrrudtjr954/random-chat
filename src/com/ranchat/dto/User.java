package com.ranchat.dto;

import com.ranchat.singletone.Singletone;

import java.net.Socket;
import java.util.Arrays;

public class User {
    private String id;
    private String name;
    private char[] pwd;
    private Socket socket;

    public User(){ }
    public User(String id, String name, char[] pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char[] getPwd() {
        return pwd;
    }

    public void setPwd(char[] pwd) {
        this.pwd = pwd;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public static boolean isUser(String id, char[] pwd){
        Singletone delegator = Singletone.getInstance();
        boolean result = delegator.getUsers().stream()
                .anyMatch(user ->
                        user.getId().equals(id) && User.isCorrectPwd(pwd, user.getPwd()));

        return result;
    }

    public static User getUserById(String id){
        Singletone delegator = Singletone.getInstance();
        User user = null;
        for (int i=0; i<delegator.getUsers().size(); i++){
            if(delegator.getUsers().get(i).getId().equals(id)){
                user = delegator.getUsers().get(i);
            }
        }

        return user;
    }

    public static boolean isCorrectPwd(char[] pwd1, char[] pwd2){
        boolean result = true;

        if (pwd1.length != pwd2.length){
            result = false;
        }else{
            for (int i=0; i<pwd1.length; i++){
                if(pwd1[i] != pwd2[i]){
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return this.id + "-" + new String(this.pwd) + "-" + this.name;
    }
}
