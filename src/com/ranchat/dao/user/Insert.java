package com.ranchat.dao.user;

import com.ranchat.dto.User;
import com.ranchat.singletone.Singletone;

public class Insert {
    public boolean insert(String id, char[] pwd, String name){
        User user = new User();
        user.setPwd(pwd);
        user.setId(id);
        user.setName(name);

        Singletone delegator = Singletone.getInstance();

        if(delegator.getUsers().add(user)){
            return true;
        }else{
            return false;
        }
    }

    public boolean insert(User user){
        Singletone delegator = Singletone.getInstance();

        if(delegator.getUsers().add(user)){
            return true;
        }else{
            return false;
        }
    }

}
