package eecs1022.lab8.tictactoe.model;

import android.provider.Settings;

public class Game {
    // Attributes
    private String playerX;
    private String playerO;
    private boolean winnerExist;
    private int changeTurn;

    private char winner;
    private String winnerName;

    private  boolean errorExist;
    private String errorMsg;
    private int attempt;

    private static char[][] board = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
    };
    // Constructor
    public Game(String playerX, String playerO) {
        this.playerO = playerO;
        this.playerX = playerX;
        Game.board = new char[][]{
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };

    }

    // Accessor
    public String getCurrentPlayer() {
        String result = null;
        this.CheckForTheWinner();

        if (!this.winnerExist) {
            if (this.changeTurn % 2 == 0) {
                result = this.playerX;
            }
            else if (this.changeTurn % 2 == 1) {
                result = this.playerO;
            }
        }

        return  result;
    }

    public String getStatus() {
        String result = this.errorMsg;
        this.CheckForTheWinner();


        if (!this.winnerExist) {
            if (!this.errorExist) {
                if (this.changeTurn % 2 == 0) {
                    result = this.playerX + "'s turn to play...";
                }
                else if (this.changeTurn % 2 == 1) {
                    result = this.playerO + "'s turn to play...";
                }
            }
        }
        else if (this.attempt == 0) {
            result = "Game is over with " + this.winnerName(this.winner) + " being the winner.";
            this.attempt ++;
        }


        return  result;
    }

    public char[][] getBoard(){
        return Game.board;

    }

    // Mutator
    public void setWhoPlaysFirst(char letter) {
        if (letter == 'o') {
            this.changeTurn = 1;
        }
        else if (letter == 'x') {
            this.changeTurn = 0;
        }
    }

    public void move(int row, int column) {
        this.errorExist = false;
        this.CheckForTheWinner();

        if (this.winnerExist) {
            this.errorExist = true;
            this.errorMsg = "Error: game is already over with a winner.";
        }
        else {
            if (row < 1 || row > 3) {
                this.errorExist = true;
                this.errorMsg = "Error: row " + row + " is invalid.";
            }
            else if (column < 1 || column > 3) {
                this.errorExist = true;
                this.errorMsg = "Error: col " + column + " is invalid.";
            }
            else {
                if (Game.board[row - 1][column - 1] != '_') {
                    this.errorExist = true;
                    this.errorMsg = "Error: slot @ (" + row + ", " + column + ") is already occupied.";
                }
                else {
                    if (this.changeTurn % 2 == 0) {
                        Game.board[row - 1][column - 1] = 'x';
                    }
                    else if (this.changeTurn % 2 == 1) {
                        Game.board[row - 1][column - 1] = 'o';
                    }
                    this.changeTurn ++;
                }
            }
        }

    }

    // Helper Method
    public void CheckForTheWinner() {
        boolean stay = true;

        // -m Diagonal
        for(int i = 0; stay && i < 3; i ++) {
            if (Game.board[i][i] == 'x') {
                this.winnerExist = true;
                this.winner = 'x';
            }
            else {
                this.winnerExist = false;
                stay = false;
            }
        }

        if (!this.winnerExist) {
            stay = true;
            for(int i = 0; stay && i < 3; i ++) {
                if (Game.board[i][i] == 'o') {
                    this.winnerExist = true;
                    this.winner = 'o';
                }
                else {
                    this.winnerExist = false;
                    stay = false;
                }
            }
        }

    // --------------------------------------------------

        // +m  Diagonal
        for(int i = 0; stay && i < 3; i ++) {
            if (Game.board[i][2 - i] == 'x') {
                this.winnerExist = true;
                this.winner = 'x';
            }
            else {
                this.winnerExist = false;
                stay = false;
            }
        }

        if (!this.winnerExist) {
            stay = true;
            for(int i = 0; stay && i < 3; i ++) {
                if (Game.board[i][2 - i] == 'o') {
                    this.winnerExist = true;
                    this.winner = 'o';
                }
                else {
                    this.winnerExist = false;
                    stay = false;
                }
            }
        }

        // -----------------------------------------------

        // Row checking
        if (!this.winnerExist) {
            stay = true;
            for (int i = 0; i < 3; i ++) {
                for (int m = 0; stay && m < 3; m ++) {
                    if (Game.board[i][m] == 'x') {
                        this.winnerExist = true;
                        this.winner = 'x';
                    }
                    else {
                        this.winnerExist = false;
                        stay = false;
                    }
                }
            }
        }

        if (!this.winnerExist) {
            stay = true;
            for (int i = 0; i < 3; i ++) {
                for (int m = 0; stay && m < 3; m ++) {
                    if (Game.board[i][m] == 'o') {
                        this.winnerExist = true;
                        this.winner = 'o';
                    }
                    else {
                        this.winnerExist = false;
                        stay = false;
                    }
                }
            }
        }

        // -----------------------------------------------------

        





    }

    public String winnerName(char c) {
        if (c == 'x') {
            this.winnerName = this.playerX;
        }
        else if (c == 'o'){
            this.winnerName = this.playerO;
        }
        return this.winnerName;
    }
}




















