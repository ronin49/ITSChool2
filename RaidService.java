package com.company;

import java.util.ArrayList;

public class RaidService {
    public static void backup(Computer computer, Raid raid) {
        for (int i = 0; i < raid.users.size(); i++) {
            if (computer.GetUser() == raid.users.get(i)) {
                for (var file : computer.GetFiles())
                    raid.files.get(i).add(file);
                return;
            }
        }
        raid.users.add(computer.GetUser());
        raid.files.add(new ArrayList<String>());
        for (var file : computer.GetFiles())
            raid.files.get(raid.files.size()-1).add(file);
    }
    public static void loadPrev(Computer computer, Raid raid) {
        for (int i = 0; i < raid.users.size(); i++) {
            if (computer.GetUser() == raid.users.get(i)) {
                ComputerService.createFile(computer,raid.files.get(i).get(raid.files.get(i).size()-1));
                return;
            }
        }
    }
    public static ArrayList<String> loadUserFiles(String user, Raid raid, String rootPass) {
        if(rootPass == "alpine") {
            for (int i = 0; i < raid.users.size(); i++) {
                if (user == raid.users.get(i)) {
                    return raid.files.get(i);
                }
            }
        }
        return null;
    }
}
