package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // starts the game
        startGame();
    }
    public static void startGame() {
        // create scanner
        Scanner sc = new Scanner(System.in);
        //track if the players want to play again
        boolean playAgain = true;
        // start game loop
        while (playAgain) {
            // create tictactoe object
            TicTacToe game = new TicTacToe();
            // starts one game
            game.play();
            // After game finishes, asks if the players want to play again
            System.out.println("Do you want to play again? Type Y for yes or anything else for no.");
            // gets input
            String input = sc.nextLine();
            // playAgain boolean is updated according to the input
            playAgain = input.toUpperCase().trim().equals("Y");
        }
        // if the players did not want to play again
        System.out.println("Good bye...");
    }
}
