package com.colm;

import java.util.*;

public class Main {
    public static int MAX_VALUE = 48;
    public static int MIN_VALUE = 1;
    public static int NUMBERS_IN_LINE = 6;
    public static int MAX_NUMBER_OF_LINES = 10;

    public static void main(String[] args) {
//        List<Integer> line = readLineFromUser();
        List<List<Integer>> lines = new ArrayList<>();
        while (lines.size() < MAX_NUMBER_OF_LINES) {
            List<Integer> line = generateRandomLine();
            System.out.println("Entered Numbers");
            printLine(line);
            System.out.println();
            lines.add(line);
        }
        System.out.println("Result : ");
        List<Integer> result = generateRandomLine();
        printLine(result);
        System.out.println();
        for (List<Integer> line : lines) {
            System.out.println("----------------------------------------");
            compareLines(line, result);
        }
    }

    public static List<Integer> readLineFromUser() {
        List<Integer> line = new ArrayList<>();
        System.out.println("Please Enter your " + NUMBERS_IN_LINE + " Lotto Numbers, they must be between " + MIN_VALUE + " and " + MAX_VALUE + " inclusive.");
        while (line.size() < NUMBERS_IN_LINE) {
            line.add(readValidIntFromUser(line));
        }
        Collections.sort(line);
        printLine(line);
        return line;
    }

    public static Integer readValidIntFromUser(List<Integer> lineSoFar) {
        Scanner scanner = ScannerFactory.getScanner();
        Integer nextNumber = -1;
        while (true) {
            printLine(lineSoFar);
            int intFromUser = scanner.nextInt();
            if (!lineSoFar.contains(intFromUser) && intFromUser >= MIN_VALUE && intFromUser < MAX_VALUE) {
                nextNumber = intFromUser;
                break;
            }
            System.out.println("Not a valid number, try again");
        }
        return nextNumber;
    }

    public static void printLine(List<Integer> line) {
        if (line != null && !line.isEmpty()) {
            System.out.print(line.toString());
        }
    }

    public static List<Integer> generateRandomLine() {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        while (result.size() < NUMBERS_IN_LINE) {
            Integer randomInt = random.nextInt(MAX_VALUE - 1) + 1;
            if (result.contains(randomInt)) {
                // Go to next iteration of loop
                continue;
            }
            result.add(randomInt);
        }
        Collections.sort(result);
        return result;
    }

    public static void compareLines(List<Integer> userLine, List<Integer> result) {
        List<Integer> matches = new ArrayList<>();
        for (Integer i : userLine) {
            if (result.contains(i)) {
                matches.add(i);
            }
        }
        if (!matches.isEmpty()) {
            System.out.println(matches.size() + " Matched for " + userLine.toString());
            System.out.println("Matches : " + matches.toString());
        } else {
            System.out.println("Nothing Matched for : " + userLine.toString());
        }
    }
}
