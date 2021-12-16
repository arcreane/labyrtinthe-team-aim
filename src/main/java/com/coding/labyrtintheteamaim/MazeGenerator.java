package com.coding.labyrtintheteamaim;

import java.io.*;
import java.util.Collections;
import java.util.Arrays;
import com.coding.labyrtintheteamaim.MazeSolver;

import static com.coding.labyrtintheteamaim.MazeConfigurator.start;
import static com.coding.labyrtintheteamaim.MazeSolver.*;

//recursive backtracking algorithm

public class MazeGenerator {
    private final int x;
    private final int y;
    private final int[][] maze;

    public MazeGenerator(int width, int height) {
        this.x = width;
        this.y = height;
        maze = new int[this.x][this.y];
        generateMaze(0, 0);

    }

    public void display() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Solution.txt", false));

        for (int i = 0; i < y; i++) {
            // draw the north edge
            for (int j =0; j < x; j++) {
                System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
                writer.write((maze[j][i] & 1) == 0 ? "+---" : "+   ");
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
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, x) && between(ny, y) && (maze[nx][ny] == 0)) {

                maze[cx][cy] |= dir.bit ; // to add the maze entrance
                maze[nx][ny] |= dir.opposite.bit;
                generateMaze(nx, ny);
            }
        }
    }

    private static boolean between(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    private enum DIR {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;

        // use the static initializer to resolve forward references
        static {
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

    public static void main (String[] args) throws IOException
    {
        start();
        InputStream f = new FileInputStream("Solution.txt");
        String[] lines = readLines (f);
        char[][] maze = decimateHorizontally (lines);
        solveMaze (maze);
        String[] solvedLines = expandHorizontally (maze);
        for (int i = 0  ;  i < solvedLines.length  ;  i++)
            System.out.println (solvedLines[i]);
    }

}
