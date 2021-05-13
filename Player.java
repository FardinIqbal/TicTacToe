package com.company;

import java.util.Scanner;

public class Player {
    private final String name;
    private final String symbol;
    private final Board board;

    public Player(String name, String symbol, Board board) {
        this.name = name;
        this.symbol = symbol;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void insertSymbol() {
        board.insertSymbolAt(getCoords(), symbol);
    }

    private int[] getCoords() {
        int x = askForCoords("X");
        int y = askForCoords("Y");
        while (!board.getBoard()[x][y].equals(" ")) {
            System.out.println("Your coordinate is not available. Try again.");
            x = askForCoords("X");
            y = askForCoords("Y");
        }
        return new int[]{x,y};
    }

    private int askForCoords(String dimension) {
        Scanner sc = new Scanner(System.in);
        System.out.println(name + ": Enter your " + dimension + "-coordinate (1-3): ");
        int x = sc.nextInt();
        while (x < 1 || x > 3) {
            System.out.println("Your coordinate is out of bounds. Try again.");
            x = sc.nextInt();
        }
        if (dimension.equals("Y"))
            return 3 - x;
        else
            return x - 1;

    }
}