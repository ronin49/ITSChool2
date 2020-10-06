package com.company;

public class StudentService {
    public static String getLogin(Student student) {
        return student.login;
    }
    public static String getPassword(Student student) {
        return student.password;
    }
    public static void raiseReputation(Student student) {
        student.smartness++;
    }
    public static void ask(Student student) {
        student.smartness++;
    }
}
