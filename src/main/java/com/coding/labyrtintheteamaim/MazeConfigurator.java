package com.coding.labyrtintheteamaim;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static com.coding.labyrtintheteamaim.MazeSolver.Solution;

public class MazeConfigurator {

    public static void start() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                MENU\s
                1- Play \s
                2- Quit \s
                """);
        System.out.print("--> ");
        int menuNumber = scanner.nextInt();
        System.out.println(" ");

        if (menuNumber == 1){

            System.out.println("""
                    Chose your game mode :\s
                    1 - Easy\s
                    2 - Medium\s
                    3 - Hard\s
                    4 - Custom\s
                    5 - Back to main menu\s
                    """);
            System.out.print("--> ");
            int gameModeNumber = scanner.nextInt();
            System.out.println(" ");

            if (gameModeNumber == 1){
                int width = 10;
                int height = 10;

                //To prevent player that the game will start
                try {
                    System.out.println("The game is starting\n" +
                            " ");
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //

                MazeGenerator maze = new MazeGenerator(width, height); //create maze
                maze.display(); //Show the maze


            }else if (gameModeNumber == 2){
                int width = 15;
                int height = 15;

                //To prevent player that the game will start
                try {
                    System.out.println("The game is starting\n" +
                            " ");
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //

                MazeGenerator maze = new MazeGenerator(width, height);//create maze
                maze.display(); //Show the maze


            }else if (gameModeNumber == 3){
                int width = 30;
                int height = 30;

                //To prevent player that the game will start
                try {
                    System.out.println("The game is starting\n" +
                            " ");
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //

                MazeGenerator maze = new MazeGenerator(width, height);//create maze
                maze.display(); //Show the maze


            }else if (gameModeNumber == 4){

                System.out.println("Chose maze's width under 100:");
                System.out.print("--> ");
                int width = scanner.nextInt();
                System.out.println(" ");

                System.out.println("Chose maze's height under 100 :");
                System.out.print("--> ");
                int height = scanner.nextInt();
                System.out.println(" ");

                //To prevent player that the game will start
                try {
                    System.out.println("The game is starting\n" +
                            " ");
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //

                MazeGenerator maze = new MazeGenerator(width, height);//create maze
                maze.display(); //Show the maze


            }else if (gameModeNumber == 5){
                start();
            }

            if (gameModeNumber>=1 && gameModeNumber<=4){

                Scanner scan = new Scanner(System.in);
                Chrono chrono = new Chrono();
                chrono.start();
                System.out.println("Write Finish or F when you've done");
                System.out.print("--> ");

                boolean valid = true;

                //loop the program until the player enter F or Finish
                while (valid) {
                    String mazeNumber = scan.nextLine();
                    if (Objects.equals(mazeNumber, "Finish") || Objects.equals(mazeNumber, "F") ){
                        chrono.stop();
                        System.out.println("Congrats you finish the maze !\n" +
                                "Your time is : " + chrono.getDureeTxt());
                        System.out.println();
                        valid = false;
                    }else {
                        System.out.println("Wrong : You need to write Finish or F !");
                        System.out.print("--> ");
                    }
                }

                System.out.println("""
                        You want to :
                        1 - Show solution
                        2 - Back to Main Menu""");
                System.out.print("\n" +
                        "--> ");
                int result = scanner.nextInt();
                System.out.println(" ");

                if (result == 1) {
                    Solution();
                    System.out.println(" ");
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
