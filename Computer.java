package com.company;

import java.util.ArrayList;

public class Computer {
    private String user;
    private ArrayList<String> files;

    Computer() {
        user="";
        files = new ArrayList<String>();
    }

    String GetUser() {
        return user;
    }

    void SetUser(String user) {
        if(user.length()!=0) {
            this.user = user;
        }
    }

    ArrayList<String> GetFiles() {
        return files;
    }
}
