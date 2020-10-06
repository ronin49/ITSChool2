package com.company;

import java.util.ArrayList;

public class LogInService {
    public ArrayList<String> logins = new ArrayList<String>();
    public ArrayList<String> passwords = new ArrayList<String>();
    public boolean login(Student student, Computer computer) {
        for(int i = 0; i < logins.size(); i++)
            if(StudentService.getLogin(student) == logins.get(i)&&StudentService.getPassword(student)==passwords.get(i)) {
                ComputerService.setUser(computer,StudentService.getLogin(student));
                return true;
            }
        return false;
    }
}
