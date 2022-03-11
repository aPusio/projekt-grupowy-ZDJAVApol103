package org.example.testpackage;

import java.util.Scanner;

public class IoService {
    private final Scanner scanner = new Scanner(System.in);

    public int getNextInt(String message){
        System.out.println(message);
        return scanner.nextInt();
    }
}
