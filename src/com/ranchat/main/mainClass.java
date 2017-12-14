package com.ranchat.main;

import com.ranchat.dto.User;
import com.ranchat.singletone.Singletone;
import com.ranchat.view.Main;

public class mainClass {
    public static void main(String[] args) {
        Singletone delegator = Singletone.getInstance();
        char pwd[] = {'1', '2', '3'};
        delegator.addUser(new User("qkrrudtjr", "qkrrudtjr", pwd));

        new Main();
    }
}
