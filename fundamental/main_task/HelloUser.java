package com.epam.trainning.ngocnhung.fundamental.main_task;

import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        String userName = nameScanner.nextLine();
        System.out.println("Hello " + userName);
    }
}
