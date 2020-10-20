package com.company;

public class ComputerService {
    public static void setUser(Computer computer, String user) {
        computer.SetUser(user);
    }
    public static void createFile(Computer computer, String filename) {
        computer.GetFiles().add(filename);
    }
    public static void logout(Computer computer) {
        computer.GetFiles().clear();
        computer.SetUser("guest");
    }
}
