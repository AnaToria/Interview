package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter number : ");
        int amount=scanner.nextInt();
        System.out.println("Minimal amount of coins : " + minSplit(amount));
    }

    public static int minSplit(int amount){
        int[] coin={1,5,10,20,50}; // array of coins
        int result=0;

        // reverse through array members
        for (int i= coin.length-1; i>=0; i--){
            // check how many times coin can be used for exchange
            while (amount-coin[i]>=0){
                ++result;
                amount-=coin[i];
            }
        }

        return  result;
    }
}
