package view;

import java.util.Scanner;

public class Viewer {

    Scanner scanner;
    public Viewer() {
        scanner = new Scanner(System.in);
    }

    public String scanData(){
            String result = scanner.nextLine();
            return result;
    }

    public void printInConsole(String message){
        System.out.println(message);
    }
}
