package com.company;

import java.util.Scanner;

// Manages all player related functionalities
public class Player {
    private final String name;
    private final String symbol;
    private final Board board;

    // Constructor
    public Player(String name, String symbol, Board board) {
        // initialize Player with  name, symbol (X or O) and board.
        this.name = name;
        this.symbol = symbol;
        this.board = board;
    }

    // insertSymbol
    public void insertSymbol() {
        // gets valid coordinate from user and inserts their symbol at that coordinate
        board.insertSymbolAt(getCoord(), symbol);
    }

    // getCoords
    private int[] getCoord() {
        // get coordinates from user
        int x = askForCoord("X");
        int y = askForCoord("Y");
        // if the coordinate is no available
        while (!board.getBoard()[x][y].equals(" ")) {
            //display error message
            System.out.println("Your coordinate is not available. Try again.");
            // get coordinates from user
            x = askForCoord("X");
            y = askForCoord("Y");
        }
        // convert integers to array for coordinate
        return new int[]{x,y};
    }

    // askForCoord
    private int askForCoord(String dimension) {
        // gets an integer with in the range of the range of the board
        // initialize scanner
        Scanner sc = new Scanner(System.in);
        // ask for coordinates
        System.out.println(name  +" (" + symbol + ")" + ": Enter your " + dimension + "-coordinate (1-3): ");
        // getInput
        int x = sc.nextInt();
        // until the entered coordinates are within range
        while (x < 1 || x > 3) {
            // display error message and ans again for coordinates
            System.out.println("Your coordinate is out of bounds. Try again.");
            // get input
            x = sc.nextInt();
        }
        // logic to make board go orientate from bottom left to top right
        if (dimension.equals("Y"))
            return 3 - x;
        else
            return x - 1;

    }

    // getName
    public String getName() {
        // accessor for name
        return name;
    }

    // getSymbol
    public String getSymbol() {
        // accessor for symbol
        return symbol;
    }

}