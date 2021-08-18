package com.epam.service.impl;

import com.epam.service.InputProcessor;

import java.util.Locale;
import java.util.Scanner;

public class InputProcessorImlp implements InputProcessor {

    private Scanner sc;
    private static int RESTART_VALUE;

    public InputProcessorImlp(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public int getConsoleIntInput() {
        int result;
        if (sc.hasNextInt()) {
            result = sc.nextInt();
        } else {
            result = RESTART_VALUE;

            clearConsoleInput();
        }
        clearConsoleInput();
        return result;

    }

    @Override
    public String getConsoleWordInput() {

        String result;

        result = sc.nextLine();
        if (result.equals("")) {
            print("Input cannot be null!");
            result = getConsoleWordInput();
        }
        if (result.contains("\\d+")) {
            print("Incorrect word! Try again...");
            result = getConsoleWordInput();
        }
        return result.toLowerCase(Locale.ROOT).trim();


    }

    @Override
    public void clearConsoleInput() {
        String rubbish;
        rubbish = sc.nextLine();

    }
    @Override
    public void print(String message){
        System.out.println(message);
    }

}
