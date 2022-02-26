package com.epam.trainning.ngocnhung.fundamental.main_task;

import java.util.Scanner;

public class MonthOfYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a month number: ");
        int month = sc.nextInt();
        String monthOfName = "Unknown";
        switch (month) {
            case 1:
                monthOfName = "January";
                break;
            case 2:
                monthOfName = "February";
                break;
            case 3:
                monthOfName = "March";
                break;
            case 4:
                monthOfName = "April";
                break;
            case 5:
                monthOfName = "May";
                break;
            case 6:
                monthOfName = "June";
                break;
            case 7:
                monthOfName = "July";
                break;
            case 8:
                monthOfName = "August";
                break;
            case 9:
                monthOfName = "September";
                break;
            case 10:
                monthOfName = "October";
                break;
            case 11:
                monthOfName = "November";
                break;
            case 12:
                monthOfName = "December";
                break;
            default:
                System.out.println("Not a valid month number");
        }
        System.out.println("The month name is: " + monthOfName);
    }
}

