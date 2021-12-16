package com.coding.labyrtintheteamaim;

import java.io.IOException;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class MazeConfigurator {

    public static void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU \n" +
                "1- Play ; \n" +
                "2- Quit ; \n");
        System.out.print("--> ");
        int menuNumber = scanner.nextInt();
        System.out.println(" ");

        if (menuNumber == 1){

            System.out.println("Chose your game mode : \n" +
                    "1- Easy \n" +
                    "2- Medium \n" +
                    "3- Hard \n" +
                    "4- Custom \n" +
                    "5- Back to main menu \n");
            System.out.print("--> ");
            int gameModeNumber = scanner.nextInt();
            System.out.println(" ");

            if (gameModeNumber == 1){
                int width = 10;
                int height = 10;
                MazeGenerator maze = new MazeGenerator(width, height);
                maze.display();

            }else if (gameModeNumber == 2){
                int width = 25;
                int height = 25;
                MazeGenerator maze = new MazeGenerator(width, height);
                maze.display();

            }else if (gameModeNumber == 3){
                int width = 50;
                int height = 50;
                MazeGenerator maze = new MazeGenerator(width, height);
                maze.display();

            }else if (gameModeNumber == 4){

                System.out.println("Chose maze's width :");
                System.out.print("--> ");
                int width = scanner.nextInt();
                System.out.println(" ");

                System.out.println("Chose height's width :");
                System.out.print("--> ");
                int height = scanner.nextInt();
                System.out.println(" ");

                MazeGenerator maze = new MazeGenerator(width, height);
                maze.display();
            }else if (gameModeNumber == 5){
                start();
            }

            if (gameModeNumber>=1 && gameModeNumber<=4){
                Scanner scan = new Scanner(System.in);
                Chrono chrono = new Chrono();
                chrono.start();
                System.out.println("Write Finish when you've done");
                String mazeNumber = scan.nextLine();

                if (mazeNumber == "Finish"){
                    chrono.stop();
                System.out.println(chrono.getDureeSec());
                System.out.println(chrono.getDureeSec());
                System.out.println(chrono.getDureeTxt());
                }
//                System.out.println(mazeNumber);
//                chrono.stop();
//                System.out.println(chrono.getDureeSec());
//                System.out.println(chrono.getDureeSec());
//                System.out.println(chrono.getDureeTxt());
            }


        }else if (menuNumber == 2){
            System.out.println("You leave");
        }
    }
}
