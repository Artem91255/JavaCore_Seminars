package ru.gb.seminars.seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class WorkWithData
{
    public static String writeNote() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        return s;
    }
    public static String CreateStringNote() throws IOException {
        LocalDate currentDate = LocalDate.now();
        System.out.print("Введите заметку: ");
        String textOfNote = WorkWithData.writeNote();
        String result = currentDate + " --> " + textOfNote;

        return result;
    }
    public static void Start() throws IOException {
        String inputNote = WorkWithData.CreateStringNote();
        System.out.println("Дозапись в файл: "+ inputNote);

        WorkWithFile.addInFile(inputNote);
    }

}
