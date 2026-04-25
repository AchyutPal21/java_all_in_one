package com.dsa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String fullName;
            fullName = scanner.nextLine();
            System.out.println("Your name is: " + fullName);
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}