package hometasks.hometask5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.*;

import static java.nio.file.LinkOption.*;



public class Main {
    public static void main(String[] args) {
        backupFiles("D:/GeekBrains/Java Core");
        String[] nums = new String[]{"1","1","2","2","0","1","2","0","0"};
        xo(nums);
    }
    public static void backupFiles(String path){

        String dir = path;
        File[] files = new File(dir).listFiles();
        File folder = new File(path+"/backup");
        if (!folder.exists()) {
            folder.mkdir();
        }
        for (File file : files) {
            if (file.isFile()) {
                //System.out.println(file.getName());
                try {

            Path bytes = Files.copy(

                    new java.io.File(path+"/"+file.getName()).toPath(),

                    new java.io.File(folder+"/"+file.getName()).toPath(),

                    REPLACE_EXISTING,

                    COPY_ATTRIBUTES,

                    NOFOLLOW_LINKS);

        } catch (IOException e) {
            e.printStackTrace();

        }
            }
        }
    }
    public static void xo(String[] array){

            try(FileWriter writer = new FileWriter("xoHistory.txt", false))
            {
                int count2 =0;
                for (int i = 0; i < array.length; i++) {
                    if(count2%3==0 && count2!=0)
                    {
                        writer.append("\n");
                    }
                    writer.write(array[i]+ "\t");
                    count2++;
                }
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }

        try(FileReader reader = new FileReader("xoHistory.txt"))
        {


            int c;
            while((c=reader.read())!=-1){

                if((char)c=='0')
                {
                    System.out.print("•");
                }
                else if((char)c=='1')
                {
                    System.out.print("X");
                }
                else if((char)c=='2')
                {
                    System.out.print("O");
                }
                else
                {
                    System.out.print((char)c);
                }

            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
