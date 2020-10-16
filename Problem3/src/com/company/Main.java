package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Length of the array : ");
        int length=s.nextInt();

        System.out.println("Enter the elements : ");
        int[] array = new int[length];
        for (int i=0; i<length; i++){
            array[i]=s.nextInt();
        }

        System.out.println("Minimum not contained number: " + notContains(array));

    }

    public static int notContains(int[] array){
        // sort array in ascending order
        Arrays.sort(array);

        // possible minimum value
        int min = 1;

        for (int i=0; i<array.length; i++){
            if (array[i] == min){
                ++min;
            }
        }

        return min;
    }
}
