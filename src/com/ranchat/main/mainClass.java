package com.ranchat.main;

import com.ranchat.dao.user.Insert;
import com.ranchat.dto.User;
import com.ranchat.file.FileClass;
import com.ranchat.singletone.Singletone;
import com.ranchat.view.Main;

public class mainClass {
    public static void main(String[] args) {
        FileClass.getInstance().loadUserFromFile();


        new Main();
    }
}
