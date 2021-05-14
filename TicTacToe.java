package com.company;

// Puts the other classes together to actually start a game
public class TicTacToe {
    // create board object
    private final Board board = new Board();
    // creates the two player objects
    private final Player player1 = new Player("PLayer 1", "X", board);
    private final Player player2 = new Player("PLayer 2", "O", board);
    // initializes the active player field
    private Player activePlayer;

    // constructor
    public TicTacToe() {
        // initialize TicTacToe class
        // sets active player to player 1
        activePlayer = player1;
    }

    // play
    public void play() {
        // renders board
        board.render();
        // starts game loop
        while (true) {
            // player inserts their symbol where ever they want
            activePlayer.insertSymbol();
            // renders board again to show where teh piece was inserted into the board
            board.render();
            // stops loop if the a player won or there was a draw with a fully filled board
            if (isGameOver())
                break;

            // else switches players
            toggleActivePlayer();
        }
    }

    // isGameOver
    private boolean isGameOver() {
        // checks if the game is won by the active player
        // checks if the game is a draw
        // THE ORDER OF THE METHODS IN THE RETURN STATEMENT MATTERS SINCE THE BOOLEAN METHODS PRINT MESSAGE DISPLAYING WHY THE GAME IS OVER
        return isGameWon() || isGameDraw();
    }

    // isGameWon
    private boolean isGameWon() {
        // if the board has a winning position for the active player
        if (board.isWinningBoard(activePlayer.getSymbol())){
            // print winning message for active player
            System.out.println(activePlayer.getName() + " (" + activePlayer.getSymbol() + ")" + " has won.");
            return true;
        }else {
            return false;
       }
    }

    // isGameDraw
    private boolean isGameDraw() {
        // if the board is fully filled
        if (board.isFull()) {
            // print Draw message
            System.out.println("The Game is a draw.");
            return true;
        }else {
            return false;
        }
    }

    // toggleActivePlayer
    private void toggleActivePlayer() {
        // switches active player to the non-active player
        if (activePlayer == player1) {
            activePlayer = player2;
        } else {
            activePlayer = player1;
        }
    }
}
