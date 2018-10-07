package org.olly.matillion.foodmart.cli;

import java.util.Scanner;

public class FoodmartConsoleReader {

    private Scanner scanner;

    public FoodmartConsoleReader(){
        scanner = new Scanner(System.in);
    }

    public String readLine(){
        return scanner.nextLine();
    }
}
