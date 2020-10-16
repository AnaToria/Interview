package com.company;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // take inputs
        Scanner scanner = new Scanner(System.in);
        System.out.print("From : ");
        String from=scanner.nextLine().toUpperCase();
        System.out.print("To : ");
        String to=scanner.nextLine().toUpperCase();

        double result = exchangeRate(from,to);
        if (result==0){
            System.out.println("Input error");
        } else {
            System.out.printf("1 %s - %.4f %s", from, result, to);
        }

    }

    public static double exchangeRate(String from, String to) {
        String sourceCode=readRSS("http://www.nbg.ge/rss.php");

        // parse string to string[]
        String[] lines=sourceCode.split("\n");

        // creating empty hashmap, where currency is key and rate is value
        HashMap<String, Double> currencies = new HashMap<>();

        // adding elements to the hashmap
        for (int i=0; i< lines.length; i+=5){
            currencies.put(lines[i],Double.parseDouble(lines[i+2]));
        }

        // search keys in hashmap
        if (currencies.containsKey(from) && currencies.containsKey(to)) {
            return currencies.get(to)/currencies.get(from);
        } else {
            return 0;
        }

    }

    public static String readRSS(String urlAddress) {
        String sourceCode = "";
        try {
            URL rssURL = new URL(urlAddress);
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(rssURL.openStream()));
                String line;
                while ((line=in.readLine())!=null){
                    if(line.contains("<td>")) {
                        int firstPos =line.indexOf("<td>");
                        String temp = line.substring(firstPos);
                        temp =temp.replace("<td>", "");
                        int lastPos = temp.indexOf("</td>");
                        temp = temp.substring(0,lastPos);
                        sourceCode += temp+ "\n";
                    }
                }
                in.close();
                return sourceCode;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
