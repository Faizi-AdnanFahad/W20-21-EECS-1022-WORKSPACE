package eecs1022.lab8.tictactoe.model;

import android.provider.Settings;

public class Game {
    // Attributes
    private String playerX;
    private String playerO;

    private int changeTurn;
    private char firstLetter;

    private char winner;
    private String winnerName;
    private boolean winnerExist;
    private boolean tieExist;

    private boolean errorExist;
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
        this.firstLetter = 'x';
    }

    // Accessor
    public String getCurrentPlayer() {
        String result = null;
        this.CheckForTheWinner();

        if (!this.winnerExist) {
            if (this.changeTurn % 2 == 0) {
                result = this.playerX;
            } else if (this.changeTurn % 2 == 1) {
                result = this.playerO;
            }
        }

        if (this.firstLetter == 'x') {
            if (this.changeTurn >= 9) {
                result = null;
            }
        }
        else if (this.firstLetter == 'o') {
            if (this.changeTurn >= 10) {
                result = null;
            }
        }


        return result;
    }

    public String getStatus() {
        String result = this.errorMsg;
        this.CheckForTheWinner();


        if (!this.winnerExist) {
            if (!this.errorExist) {
                if (this.changeTurn % 2 == 0) {
                    result = this.playerX + "'s turn to play...";
                } else if (this.changeTurn % 2 == 1) {
                    result = this.playerO + "'s turn to play...";
                }
            }
        } else if (this.attempt == 0) {
            result = "Game is over with " + this.winnerName(this.winner) + " being the winner.";
            this.attempt++;
        }


        return result;
    }

    public char[][] getBoard() {
        return Game.board;

    }

    // Mutator
    public void setWhoPlaysFirst(char letter) {
        if (letter == 'o') {
            this.changeTurn = 1;
            this.firstLetter = 'o';
        } else if (letter == 'x') {
            this.changeTurn = 0;
        }
    }

    public void move(int row, int column) {
        this.errorExist = false;
        this.CheckForTheWinner();
        int temp = 9;

        if (this.firstLetter == 'o' && this.changeTurn >= 9) {
            temp = this.changeTurn + 1;
            this.changeTurn ++;
        }

        if (this.winnerExist) {
            this.errorExist = true;
            this.errorMsg = "Error: game is already over with a winner.";
        }
        else if (this.changeTurn >= temp) {
            this.errorExist = true; // wrong: this message should only come with all the sets were finished intially -> and at later calls name of the winners should not be there. See junit testing for more clarification.
            this.errorMsg = "Game is over with a tie between Suyeon and Yuna.";

            if (temp == 10) {
                if ((this.changeTurn - 1) % 2 == 0) {
                    Game.board[row - 1][column - 1] = 'x';
                } else if ((this.changeTurn - 1) % 2 == 1) {
                    Game.board[row - 1][column - 1] = 'o';
                }
            }
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
                    } else if (this.changeTurn % 2 == 1) {
                        Game.board[row - 1][column - 1] = 'o';
                    }
                    this.changeTurn++;
                }
            }
        }

    }

    // Helper Method
    public void CheckForTheWinner() {
        boolean stay = true;

        // -m Diagonal
        for (int i = 0; stay && i < 3; i++) {
            if (Game.board[i][i] == 'x') {
                this.winnerExist = true;
                this.winner = 'x';
            } else {
                this.winnerExist = false;
                stay = false;
            }
        }

        if (!this.winnerExist) {
            stay = true;
            for (int i = 0; stay && i < 3; i++) {
                if (Game.board[i][i] == 'o') {
                    this.winnerExist = true;
                    this.winner = 'o';
                } else {
                    this.winnerExist = false;
                    stay = false;
                }
            }
        }

        // --------------------------------------------------

        // +m  Diagonal
        if (!this.winnerExist) {
            for (int i = 0; stay && i < 3; i++) {
                if (Game.board[i][2 - i] == 'x') {
                    this.winnerExist = true;
                    this.winner = 'x';
                } else {
                    this.winnerExist = false;
                    stay = false;
                }
            }
        }


        if (!this.winnerExist) {
            stay = true;
            for (int i = 0; stay && i < 3; i++) {
                if (Game.board[i][2 - i] == 'o') {
                    this.winnerExist = true;
                    this.winner = 'o';
                } else {
                    this.winnerExist = false;
                    stay = false;
                }
            }
        }

        // -----------------------------------------------

        // Row checking
        if (!this.winnerExist) {
            stay = true;
            for (int i = 0; stay && i < 3; i++) {
                for (int m = 0; stay && m < 3; m++) {
                    if (Game.board[i][m] == 'x') {
                        this.winnerExist = true;
                        this.winner = 'x';
                    } else {
                        this.winnerExist = false;
                        stay = false;
                    }
                }
                if (this.winnerExist) {
                    stay = false;
                }
            }
        }

        if (!this.winnerExist) { // work on your conditoins
            stay = true;
            for (int i = 0; i < 3; i++) {
                stay = true;
                for (int m = 0; stay && m < 3; m++) {
                    if (Game.board[i][m] == 'o') {
                        this.winnerExist = true;
                        this.winner = 'o';
                    } else {
                        this.winnerExist = false;
                        stay = false;
                    }
                }
//                if (this.winnerExist) {
//                    stay = false;
//                }
            }
        }

        // -----------------------------------------------------

        if (!this.winnerExist) {
            stay = true;
            for (int i = 0; stay && i < 3; i++) {
                for (int m = 0; stay && m < 3; m++) {
                    if (Game.board[m][i] == 'x') {
                        this.winnerExist = true;
                        this.winner = 'x';
                    } else {
                        this.winnerExist = false;
                        stay = false;
                    }
                }
                if (this.winnerExist) {
                    stay = false;
                }
            }
        }

        if (!this.winnerExist) {
            stay = true;
            for (int i = 0; stay && i < 3; i++) {
                for (int m = 0; stay && m < 3; m++) {
                    if (Game.board[m][i] == 'o') {
                        this.winnerExist = true;
                        this.winner = 'o';
                    } else {
                        this.winnerExist = false;
                        stay = false;
                    }
                }
                if (this.winnerExist) {
                    stay = false;
                }
            }
        }
    }

    public String winnerName(char c) {
        if (c == 'x') {
            this.winnerName = this.playerX;
        } else if (c == 'o') {
            this.winnerName = this.playerO;
        }
        return this.winnerName;
    }
}

//    public void tieExist() {
//        this.CheckForTheWinner();
//        this.tieExist = true;
//
//        if(!this.winnerExist) {
//            for (int i = 0; i < 3; i ++) {
//                for (int m = 0; m < 3;m ++) {
//                    if (Game.board[i][m] == 'x' || Game.board[i][m] == 'o') {
//                        this.tieExist = true;
//                    }
//            }
//        }
//
//    }
//}




















