package com.coding.labyrtintheteamaim;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static com.coding.labyrtintheteamaim.MazeSolver.Solv;
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
                System.out.println("Write Finish or F when you've done");
                System.out.print("--> ");

                boolean valid = false;

                while (valid == false) {
                    String mazeNumber = scan.nextLine();
                    if (Objects.equals(mazeNumber, "Finish") || Objects.equals(mazeNumber, "F") ){
                        chrono.stop();
//                    System.out.println(chrono.getDureeMs());
//                    System.out.println(chrono.getDureeSec());
                        System.out.println("You time is : " + chrono.getDureeTxt());
                        System.out.println();
                        valid = true;
                    }else {
                        System.out.println("Wrong : You need to write Finish or F !");
                        System.out.print("--> ");
                    }
                }

                System.out.println("You want to :\n" +
                        "1- Show solution\n" +
                        "2- Back to Main Menu");
                System.out.print("\n" +
                        "--> ");
                int result = scanner.nextInt();
                System.out.println(" ");

                if (result == 1) {
                    Solv();
                    System.out.println("");
                    start();
                }else if (result == 2) {
                    start();
                }
            }

        }else if (menuNumber == 2){
            System.out.println("You are leaving ");
        }
    }
}
