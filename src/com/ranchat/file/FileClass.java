package com.ranchat.file;

import com.ranchat.dao.user.Insert;
import com.ranchat.dto.User;
import com.ranchat.singletone.Singletone;

import java.io.*;
import java.util.List;

public class FileClass {
    private static File userFile;
    private static File coffeeFile;
    private static File orderFile;

    private static FileClass instance = null;


    private FileClass() {
        userFile = new File("/Users/parker/Desktop/Users.txt");
        coffeeFile = new File("/Users/parker/Desktop/Coffees.txt");
        orderFile = new File("/Users/parker/Desktop/Orders.txt");


        try {
            if (userFile.createNewFile() && coffeeFile.createNewFile() && orderFile.createNewFile()) {
                System.out.println("FILE created");
            }else {
                System.out.println("FILE exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static FileClass getInstance(){
        if(instance == null){
            instance = new FileClass();
        }
        return instance;
    }

    public static void writeUserToFile(){
        Singletone delegator = Singletone.getInstance();
        List<User> users = delegator.getUsers();

        if(userFile != null ){
            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(userFile)));

                users.stream().forEach(user -> {
                    pw.println(user.toString());
                });
                pw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadUserFromFile(){
        if(userFile!=null){
            try {
                BufferedReader br = new BufferedReader(new FileReader(userFile));
                String temp[] = null;
                String str;
                User tempUser = null;
                char[] password;

                while((str = br.readLine()) != null){
                    temp = str.split("-");

                    tempUser = new User();
                    tempUser.setId(temp[0]);

                    password = new char[temp[1].length()];
                    for (int i=0; i<temp[1].length(); i++){
                        password[i] = temp[1].charAt(i);
                    }
                    tempUser.setPwd(password);
                    tempUser.setName(temp[2]);

                    Insert userInsert = new Insert();
                    userInsert.insert(tempUser);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
