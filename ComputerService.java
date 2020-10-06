package com.company;

public class ComputerService {
    public static void setUser(Computer computer, String user) {
        computer.user = user;
    }
    public static void createFile(Computer computer, String filename) {
        computer.files.add(filename);
    }
    public static void logout(Computer computer) {
        computer.files.clear();
        computer.user="";
    }
}
