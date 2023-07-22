package ru.gb.seminars.seminar1;

import java.io.*;
import java.time.LocalDate;


public class WorkWithFile {
    public static void addInFile(String textOfNote)

    {
        LocalDate currentDate = LocalDate.now();
        String date = String.valueOf(currentDate);
        File file = new File("notes2.txt");
        try {
            FileWriter fr = new FileWriter(file,true);
            fr.write("\n");
            fr.write(textOfNote);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }



