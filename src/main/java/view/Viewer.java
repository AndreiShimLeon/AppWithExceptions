package view;

import java.util.Scanner;

public class Viewer {
    public String scanData(String message){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println(message);
            return scanner.nextLine();
        }
    }

    public void printInConsole(String message){
        System.out.println(message);
    }
}
