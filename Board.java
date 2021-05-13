package com.company;


import java.util.Arrays;

public class Board {
    public String[][] board;
    public Board() {
        board = new String[][] {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };
    }

    public void render(){
        System.out.println("  -------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print(3 - row + " |");
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(" " + board[col][row] + " ");
                System.out.print("|");
            }
            System.out.println();
            System.out.println("  -------------");
        }
        System.out.println("    1   2   3");
    }

    public void insertSymbolAt(int[]coords, String symbol) {
        if (coordinatesValid(coords) && coordinatesAvailable(coords))
            board[coords[0]][coords[1]] = symbol;
    }

    public boolean coordinatesValid(int[] coords) {
        if (coords[0] >= 0 && coords[0] <= 2 && coords[1] >= 0 && coords[1] <= 2) {
            return true;
        } else {
            System.out.println("Your coordinates are out of bounds");
            return false;
        }
    }

    public boolean coordinatesAvailable(int[] coords) {
        if (board[coords[0]][coords[1]].equals(" "))
            return true;
        else
            System.out.println("Your coordinates are out of not available");
            return false;
    }

    public boolean isWinningBoard(String symbol) {
        return hasWinningCol(symbol) ||
                hasWinningRow(symbol) ||
                hasWinningDiagonal(symbol);
    }

    public boolean hasWinningDiagonal(String symbol) {
        return (board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) ||
                (board[2][0].equals(symbol) && board[1][1].equals(symbol) && board[0][2].equals(symbol));
    }

    public boolean hasWinningCol(String symbol) {
        return  (board[0][0].equals(symbol) && board[1][0].equals(symbol) && board[2][0].equals(symbol))||
                (board[1][0].equals(symbol) && board[1][1].equals(symbol) && board[1][2].equals(symbol))||
                (board[2][0].equals(symbol) && board[2][1].equals(symbol) && board[2][2].equals(symbol));
    }

    public boolean hasWinningRow(String symbol) {
        return  (board[0][0].equals(symbol) && board[0][1].equals(symbol) && board[0][2].equals(symbol))||
                (board[1][0].equals(symbol) && board[1][1].equals(symbol) && board[1][2].equals(symbol))||
                (board[2][0].equals(symbol) && board[2][1].equals(symbol) && board[2][2].equals(symbol));
    }

    public boolean  isFull() {
        for (String[] row : board) {
            for (String cell : row) {
                if (cell.equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
    public String toString() {
        return Arrays.deepToString(board);
    }

    public String[][] getBoard() {
        return board;
    }
}
