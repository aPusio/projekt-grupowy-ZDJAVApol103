package org.example.learnig.testpackage;

public class UserCalculator {
    private IoService ioService;

    public UserCalculator(IoService ioService) {
        this.ioService = ioService;
    }

    public Integer addition(){
        System.out.println("DODAWANIE ! 🤣");
//        System.out.println("PODAJ A");
//        int a = scanner.nextInt();
        int a = ioService.getNextInt("PODAJ A");
        System.out.println();
//        System.out.println("PODAJ B");
//        int b = scanner.nextInt();
        int b = ioService.getNextInt("PODAJ B");

        return a + b;
    }
}
