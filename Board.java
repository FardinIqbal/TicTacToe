package com.company;

// Manages all board related functionality
public class Board {
    // board array field
    private final String[][] board;

    public Board() {
        // initialize blank 2D board array
        board = new String[][] {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };
    }

    // render
    public void render(){
        // top board boundary
        System.out.println("  -------------");
        // loop through the each cell of teh board
        for (int row = 0; row < board.length; row++) {
            // print row number
            System.out.print(3 - row + " |");
            for (int col = 0; col < board[0].length; col++) {
                // print the cells
                System.out.print(" " + board[col][row] + " ");
                // print cell divider
                System.out.print("|");
            }
            System.out.println();
            // print row divider
            System.out.println("  -------------");
        }
        // print column number
        System.out.println("    1   2   3");
    }

    // insertSymbolAt
    public void insertSymbolAt(int[]coord, String symbol) {
        // if coordinate is valid
        if (coordinateIsValid(coord))
            // set specified coordinate in the board the specified symbol
            board[coord[0]][coord[1]] = symbol;
    }

    // coordinateIsValid
    public boolean coordinateIsValid (int[] coord) {
        // checks if coordinates are with in range and empty
        return coordinateIsInRange(coord) && coordinateIsAvailable(coord);
    }

    // coordinateIsInRange
    public boolean coordinateIsInRange(int[] coord) {
        // if coordinate is with in the range
        if (coord[0] >= 0 && coord[0] <= 2 && coord[1] >= 0 && coord[1] <= 2)
            return true;
         else
            // print error messages explaining the problem
            System.out.println("Your coordinates are out of bounds");
            return false;

    }

    //coordinateIsAvailable
    public boolean coordinateIsAvailable(int[] coord) {
        // if the coordinate cell is empty
        if (board[coord[0]][coord[1]].equals(" "))
            return true;
        else
            // print error messages explaining the problem
            System.out.println("Your coordinates are out of not available");
            return false;
    }

    // isWinningBoard
    public boolean isWinningBoard(String symbol) {
        return
                // Checks if there is a winning row
                isWinningRow(symbol) ||
                // or winning column
                isWinningCol(symbol) ||
                // or winning diagonal
                isWinningDiagonal(symbol);
    }

    // isWinningDiagonal
    public boolean isWinningDiagonal(String symbol) {
        // checks if either diagonal has 3 of the specified symbol
        return (board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) ||
                (board[2][0].equals(symbol) && board[1][1].equals(symbol) && board[0][2].equals(symbol));
    }

    // isWinningCol
    public boolean isWinningCol(String symbol) {
        // checks if any column has 3 of the specified symbol
        return  (board[0][0].equals(symbol) && board[1][0].equals(symbol) && board[2][0].equals(symbol))||
                (board[0][1].equals(symbol) && board[1][1].equals(symbol) && board[2][1].equals(symbol))||
                (board[0][2].equals(symbol) && board[1][2].equals(symbol) && board[2][2].equals(symbol));
    }

    // isWinningRow
    public boolean isWinningRow(String symbol) {
        // checks if any of the rows has 3 of the specified symbol
        return (board[0][0].equals(symbol) && board[0][1].equals(symbol) && board[0][2].equals(symbol))||
                (board[1][0].equals(symbol) && board[1][1].equals(symbol) && board[1][2].equals(symbol))||
                (board[2][0].equals(symbol) && board[2][1].equals(symbol) && board[2][2].equals(symbol));
    }

    // isFull
    public boolean isFull() {
        // checks every cell inside the board array
        for (String[] row : board) {
            for (String cell : row) {
                // if cell is empty
                if (cell.equals(" ")) {
                    return false;
                }
            }
        }
        // if every cell is filled
        return true;
    }

    // getBoard
    public String[][] getBoard() {
        // accessor for board
        return board;
    }
}
