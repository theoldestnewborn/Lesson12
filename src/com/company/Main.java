package com.company;


public class Main {
    public static void main(String[] args) {

        DocReader file1 = new DocReader();
        DocWriter file2 = new DocWriter();
        file1.pathFinder();
        file1.readFromFile(file1.getPath());
        file2.newDocFile(file1.getNewStrings());
    }
}
