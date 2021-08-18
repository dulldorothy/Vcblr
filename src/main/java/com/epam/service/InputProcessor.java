package com.epam.service;

public interface InputProcessor {

    int getConsoleIntInput();
    String getConsoleWordInput();
    void clearConsoleInput();
    void print(String message);
}
