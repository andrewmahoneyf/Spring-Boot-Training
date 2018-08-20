package com.example.demo;

public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mult(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        if (a > 0 && b > 0) return a / b;
        return 0;
    }

    public static int mod(int a, int b) {
        return a % b;
    }
}
