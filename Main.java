package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        startGame();
    }
    public static void startGame() {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            TicTacToe game = new TicTacToe();
            game.play();
            System.out.println("Do you want to play again? Type Y for yes or anything else for no.");
            String input = sc.nextLine();
            playAgain = input.toUpperCase().trim().equals("Y");
        }
        System.out.println("Good bye...");
    }
}
