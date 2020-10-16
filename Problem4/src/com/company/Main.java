package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sequence : ");
        String sequence = scanner.nextLine();

        if (isProperly(sequence)) {
            System.out.println("Correct");
        } else {
            System.out.println("Wrong");
        }

    }

    public static boolean isProperly(String sequence){
        Stack<Character> braces = new Stack<>();

        for (int i=0; i<sequence.length(); i++) {
            if(sequence.charAt(i) == '(') {
                braces.push('(');
            }
            if (sequence.charAt(i) == ')') {
                if (!braces.empty()) {
                    braces.pop();
                } else {
                    return false;
                }
            }
        }

        return  (braces.empty());
    }
}
