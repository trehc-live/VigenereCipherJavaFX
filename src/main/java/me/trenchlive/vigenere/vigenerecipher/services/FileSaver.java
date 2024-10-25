package me.trenchlive.vigenere.vigenerecipher.services;

import java.io.FileWriter;
import java.io.IOException;

public class FileSaver{
    public static void saveFile(String path, String file){
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(file);
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
