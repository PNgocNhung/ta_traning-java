package com.epam.trainning.ngocnhung.fundamental.main_task;

public class ReverseOrder {
    public static void main(String[] args) {
        for (int i = 0; i < args.length / 2; i++) {
            String temp = args[i];
            args[i] = args[args.length - i - 1];
            args[args.length - i - 1] = temp;
        }
        System.out.println("Here is your reverse list:");

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
