package com.ranchat.dto;

import java.net.Socket;
import java.util.Arrays;

public class User {
    private String id;
    private String name;
    private char[] pwd;
    private Socket socket;


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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd=" + Arrays.toString(pwd) +
                ", socket=" + socket +
                '}';
    }
}
