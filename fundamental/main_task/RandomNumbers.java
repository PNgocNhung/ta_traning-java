package com.epam.trainning.ngocnhung.fundamental.main_task;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how many number(s) you need: ");
        int totalNumber = sc.nextInt();
        System.out.println("Please tell me the starting point for the range: ");
        int starter = sc.nextInt();
        System.out.println("Please tell me the ending point for the range: ");
        int finisher = sc.nextInt();
        System.out.println("Here is your random number(s): ");
        for (int i = 1; i <= totalNumber; i++) {
            int randomNumber = randomRange(starter, finisher);
            System.out.print(randomNumber + " ");
        }
    }

    public static int randomRange(int starter, int finisher) {
        Random rnd = new Random();
        int randomNumber = starter + rnd.nextInt(finisher + 1 - starter);
        return randomNumber;
    }

}
