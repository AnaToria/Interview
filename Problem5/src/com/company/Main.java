package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of stairs : ");
        int stairCount= scanner.nextInt();

        System.out.println("All possible variants : " + countVariants(stairCount));
    }

    public static int countVariants(int stairCount){
        if (stairCount <= 0) {
            return 0;
        }
        if (stairCount == 1) {
            return 1;
        }
        if (stairCount == 2){
            return 2;
        }
        return countVariants(stairCount-1)+countVariants(stairCount-2);
    }
}
