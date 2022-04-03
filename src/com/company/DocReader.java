package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DocReader {
    private int arrayLength;

    public String[] getNewStrings() {
        return newStrings;
    }

    public String[] newStrings;
    public String getPath() {
        return path;
    }

    String path;
    public String pathFinder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите имя файла в корневом каталоге");
        for (; ; ) {
            path = scanner.nextLine();
            File check = new File(path);
            if (check.exists() == true) {
                return path;
            } else {
                System.out.println("Wrong name, try again");
            }
        }
    }

    public String[] readFromFile(String path) {
        try (FileReader fis1 = new FileReader(path)) {
            while ((fis1.read()) != -1) {
                arrayLength++;
            }
            try (FileReader fis = new FileReader(path)) {
                int i = 0;
                int j = 0;
                char[] chars = new char[arrayLength];
                while ((i = fis.read()) != -1) {
                    chars[j] = ((char) i);
                    i++;
                    j++;
                }

                String string = new String(chars);
                newStrings = string.split("\n");
                System.out.println(Arrays.toString(newStrings));
            }

        } catch (NullPointerException | IOException e) {
            System.out.println("Такого файла не существует");
        }
        return newStrings;
    }
}

