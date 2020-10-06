package com.company;

import java.util.ArrayList;

public class TeachingService {
    public static void teach(Teacher teacher, ArrayList<Student> students) {
        teacher.reputation++;
        for(var student : students)
            StudentService.raiseReputation(student);
    }
    public static void check(Teacher teacher, ArrayList<Student> students) {
        for(var student : students)
            if(Math.random()>=0.5)
                StudentService.raiseReputation(student);
    }
}
