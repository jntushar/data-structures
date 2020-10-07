/*

1. You are given a number n, the size of a chess board.
2. You are given a row and a column, as a starting point for a knight piece.
3. You are required to generate the all moves of a knight starting in (row, col) such that knight visits 
     all cells of the board exactly once.
4. Complete the body of printKnightsTour function - without changing signature - to calculate and 
     print all configurations of the chess board representing the route
     of knight through the chess board. Use sample input and output to get more idea.

Note -> When moving from (r, c) to the possible 8 options give first precedence to (r - 2, c + 1) and 
               move in clockwise manner to
               explore other options.

*/



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        int row = scn.nextInt();
        int col = scn.nextInt();
        printKnightsTour(chess, row, col, 1);
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int upcomingMove) {
        if(row<0 || col<0 || row>=chess.length || col>=chess.length || chess[row][col] != 0){
            return;
        }else if(upcomingMove == chess.length * chess.length){
            chess[row][col] = upcomingMove;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        
        chess[row][col] = upcomingMove;
        printKnightsTour(chess, row - 2, col + 1, upcomingMove + 1);
        printKnightsTour(chess, row - 1, col + 2, upcomingMove + 1);
        printKnightsTour(chess, row + 1, col + 2, upcomingMove + 1);
        printKnightsTour(chess, row + 2, col + 1, upcomingMove + 1);
        printKnightsTour(chess, row + 2, col - 1, upcomingMove + 1);
        printKnightsTour(chess, row + 1, col - 2, upcomingMove + 1);
        printKnightsTour(chess, row - 1, col - 2, upcomingMove + 1);
        printKnightsTour(chess, row - 2, col - 1, upcomingMove + 1);
        chess[row][col] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}