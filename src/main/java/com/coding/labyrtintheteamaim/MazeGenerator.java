package com.coding.labyrtintheteamaim;

import java.io.*;
import java.util.Collections;
import java.util.Arrays;

//recursive backtracking algorithm

public class MazeGenerator {
    private final int x;
    private final int y;
    private final int[][] maze; //Initialize maze as double enter

    public MazeGenerator(int width, int height) {
        this.x = width;
        this.y = height;
        maze = new int[this.x][this.y];
        generateMaze(0, 0);

    }

    public void display() throws IOException { //To print the maze in terminal
        BufferedWriter writer = new BufferedWriter(new FileWriter("Solution.txt", false)); // to write the maze in Solution.txt

        for (int i = 0; i < y; i++) {
            // draw the north edge
            for (int j =0; j < x; j++) {
                System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");  // print in terminal
                writer.write((maze[j][i] & 1) == 0 ? "+---" : "+   ");      // Write in Solution.txt
            }
            System.out.println("+");
            writer.write("+\n");
            // draw the west edge
            for (int j = 0; j < x; j++) {
                System.out.print((maze[j][i] & 8) == 0 ? "|   " : "    ");
                writer.write((maze[j][i] & 8) == 0 ? "|   " : "    ");
            }
            System.out.println("|");
            writer.write("|\n");
        }
        // draw the bottom line
        for (int j = 0; j < x; j++) {
            System.out.print("+---");
            writer.write("+---");
        }
        System.out.println("+");
        writer.write("+\n");
        writer.flush();
    }

    //
    private void generateMaze(int cx, int cy) {
        DIR[] dirs = DIR.values();                  //initialise the array of directions
        Collections.shuffle(Arrays.asList(dirs));   //shuffle direction
        for (DIR dir : dirs) {
            int nx = cx + dir.dx;                   // calculate x coordinate
            int ny = cy + dir.dy;                   // calculate y coordinate
            if (between(nx, x) && between(ny, y) && (maze[nx][ny] == 0)) { //if the new coordinates are in the maze

                maze[cx][cy] |= dir.bit ;           //mark the current cell as visited
                maze[nx][ny] |= dir.opposite.bit;   //mark the new cell as visited
                generateMaze(nx, ny);
            }
        }
    }

    private static boolean between(int v, int upper) {
        return (v >= 0) && (v < upper);
        //Check if the new coordinates are in the maze
    }


    private enum DIR { //Initialize directions
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;

        // use the static initializer to resolve forward references
        static { // opposite directions
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        DIR(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    }

}
