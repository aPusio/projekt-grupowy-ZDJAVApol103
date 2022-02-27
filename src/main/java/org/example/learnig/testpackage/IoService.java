package org.example.learnig.testpackage;

import java.util.Scanner;

public class IoService {
    private Scanner scanner = new Scanner(System.in);

    public int getNextInt(String message){
        System.out.println(message);
        return scanner.nextInt();
    }
}
