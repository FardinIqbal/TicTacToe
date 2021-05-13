package com.company;

public class TicTacToe {
    private final Board board = new Board();
    private final Player playerX = new Player("PLayer 1", "X", board);
    private final Player playerO = new Player("PLayer 2", "O", board);
    private Player activePlayer;

    public TicTacToe() {
        activePlayer = playerX;
    }
    public void play() {
        board.render();
        while (true) {
            activePlayer.insertSymbol();
            board.render();
            if (isGameOver()) {
                break;
            }
            switchPlayer();
        }
    }
    public boolean isGameOver() {
        return isGameDraw() || isGameWon();
    }

    public boolean isGameWon() {
        if (board.isWinningBoard(activePlayer.getSymbol())){
            System.out.println(activePlayer.getName() + " has won.");
        return true;
        }else {
            return false;
        }
    }
    public boolean isGameDraw() {
        if (board.isFull()) {
            System.out.println("The Game is a draw.");
            return true;
        }else {
            return false;
        }
    }

    public void switchPlayer() {
        if (activePlayer == playerX) {
            activePlayer = playerO;
        } else {
            activePlayer = playerX;
        }
    }
}
