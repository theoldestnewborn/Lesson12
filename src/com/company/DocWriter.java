package com.company;

import java.io.*;
import java.util.Scanner;

public class DocWriter {
    private String newFileNameDocs,
            newFileNameOther = "OtherFiles";
    Scanner scanner = new Scanner(System.in);

    public static void createTestFile() {
        try (PrintWriter pw = new PrintWriter("D:\\JAVA\\tasks\\Lesson12\\AllDocs.txt")) {
            pw.write("docnum123456789\n" +
                    "docnum987654321\n" +
                    "contract1234567\n" +
                    "contract7654321\n" +
                    "13r4t34t554y45\n" +
                    "docnum123\n" +
                    "contract123");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void newDocFile(String[] strings) {

        System.out.println("Укажите имя файла для документов");
        newFileNameDocs = scanner.nextLine();

        try (PrintWriter pw1 = new PrintWriter(newFileNameDocs + ".txt");
             PrintWriter pw2 = new PrintWriter(newFileNameOther + ".txt")) {

            for (int i = 0; i < strings.length; i++) {
                if (strings[i].toCharArray().length == 15
                        && (strings[i].startsWith("docnum")
                        || strings[i].startsWith("contract"))) {
                    pw1.write(strings[i] + "\n");
                } else {
                    pw2.write(strings[i] + "\n");
                }
            }
            System.out.println("Остальные файлы записаны в " + newFileNameOther + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

