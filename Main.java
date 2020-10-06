package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = generateStudents(12);
        Teacher teacher = new Teacher();
        teacher.reputation = (int)Math.random()*100;
        ArrayList<Computer> computers = generateСomputers(12);
        Raid raid = new Raid();
        LogInService logInService = generateLogInServiceFromStudents(students);

        // дети заходят в свою учётку
        for(int i = 0; i < 12; i++)
            logInService.login(students.get(i),computers.get(i));

        // учитель разказывает теорию
        TeachingService.teach(teacher,students);

        // дети задают вопросы
        for(int i = 0; i < 12; i++)
            StudentService.ask(students.get(i));

        // практика
        for(int i = 0; i < 12; i++)
            ComputerService.createFile(computers.get(i),generateFilename());

        // проверка
        TeachingService.check(teacher,students);

        // конец урока, дети выходят из своих учёток или компы автоматически выключаются(с бекапом)
        for(int i = 0; i < 12; i++) {
            RaidService.backup(computers.get(i), raid);
            ComputerService.logout(computers.get(i));
        }

        // на след день дети логинятся и продолжают работать с вчерашними файлами
        for(int i = 0; i < 12; i++) {
            logInService.login(students.get(i),computers.get(i));
            RaidService.loadPrev(computers.get(i),raid);
        }

        // в случае если прийдёт Мама Васи и попросит Васины файлы
        RaidService.loadUserFiles("Вася",raid,"alpine");
    }
    static String generateFilename() {
        String filename = new String();
        for(int i = 0; i < 10; i++)
            filename+=(char)((int)(Math.random()*('z'-'a')));
        return filename;
    }
    static LogInService generateLogInServiceFromStudents(ArrayList<Student> students) {
        LogInService generatedLogInService = new LogInService();
        for(var student : students) {
            generatedLogInService.logins.add(StudentService.getLogin(student));
            generatedLogInService.passwords.add(StudentService.getPassword(student));
        }
        return generatedLogInService;
    }
    static ArrayList<Computer> generateСomputers(int computers) {
        ArrayList<Computer> generatedComputers = new ArrayList<Computer>();
        for(int i = 0; i < computers; i++) {
            Computer computer = new Computer();
            generatedComputers.add(computer);
        }
        return generatedComputers;
    }
    static ArrayList<Student> generateStudents(int students) {
        ArrayList<Student> generatedStudents = new ArrayList<Student>();
        for(int i = 0; i < students; i++) {
            Student student = new Student();
            student.smartness=(int)Math.random()*100;
            student.password = generatePassword();
            student.login = generateLogin();
            generatedStudents.add(student);
        }
        return generatedStudents;
    }
    static String generatePassword() {
        String password = new String();
        for(int i = 0; i < 4; i++)
            password+=(char)((int)(Math.random()*('9'-'0')));
        return password;
    }
    static String generateLogin() {
        String password = new String();
        for(int i = 0; i < 6; i++)
            password+=(char)((int)(Math.random()*('z'-'a')));
        return password;
    }
}