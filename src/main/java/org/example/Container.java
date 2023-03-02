package org.example;

import java.util.Scanner;

public class Container {
    private static final Scanner sc;

    static {
        sc = new Scanner(System.in);
    }
    public static Scanner getScanner(){
        return sc;
    }
}
