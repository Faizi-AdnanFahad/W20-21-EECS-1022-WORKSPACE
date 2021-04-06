package eecs1022.lab8.tictactoe.model;

public class Game {
    // Attributes
    private String playerX;
    private String playerO;
    private char currentPlayer;
    private static char[][] board = {{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};

    private int row;
    private int column;

    private boolean errorExist;
    private String errorMsg;
    private boolean specialCase;

    private int turnInt;

    // Constructor
    public Game(String playerX, String playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = 'x';
        Game.board = new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};

        this.row = 0;
        this.column = 0;

        this.errorExist = false;
    }

    // Accessor
    public String getCurrentPlayer() {
        String result = "";
        boolean contin = this.Continue(Game.board);
        if (!contin) {
            if (!specialCase) {
                if (this.turnInt % 2 == 0) {
                    result = this.playerX;
                }
                else if (this.turnInt % 2 == 1) {
                    result = this.playerO;
                }
            }
            else {
                if (this.turnInt != 1 && this.turnInt % 2 == 1) {
                    result = this.playerX;
                }
                else if (this.turnInt == 1 ) {
                    result = this.playerO;
                }
                else if (this.turnInt % 2 == 0) {
                    result = this.playerO;
                }
            }
        }
        else {
            result = null;
        }


        return  result;
    }

    public String getStatus() {
        String result = "";

        if (errorExist) {
            result = this.errorMsg;
        }
        else {
            if(!specialCase) {
                if (this.turnInt % 2 == 0) {
                    result = this.playerX + "'s turn to play...";;
                }
                else if (this.turnInt % 2 == 1) {
                    result = this.playerO + "'s turn to play...";;
                }
            }
            else {
                if (this.turnInt != 1 && this.turnInt % 2 == 1) {
                    result = this.playerX + "'s turn to play...";;
                }
                else if (this.turnInt == 1) {
                    result = this.playerO + "'s turn to play...";;
                }
                else if (this.turnInt == 0) {
                    result = this.playerO + "'s turn to play...";;
                }
            }
        }

        return  result;
    }

    public char[][] getBoard(){
        if (!specialCase) {
            if (!errorExist && this.turnInt != 0 ) {
                if (this.turnInt % 2 == 1)
                    Game.board[this.row - 1][this.column - 1] = 'x';
                else if (this.turnInt % 2 == 0) {
                    Game.board[this.row - 1][this.column - 1] = 'o';
                }
            }
        }
        else {
            if (!errorExist && this.turnInt != 1) {
                if (this.turnInt % 2 == 1)
                    Game.board[this.row - 1][this.column - 1] = 'x';
                else if (this.turnInt % 2 == 0) {
                    Game.board[this.row - 1][this.column - 1] = 'o';
                }
            }
        }

        return Game.board;
    }

    // Mutator
    public void setWhoPlaysFirst(char letter) {
        if (letter == 'o') {
            this.turnInt = 1;
            this.specialCase = true;
        }
        this.currentPlayer = letter;
    }

    public void move(int row, int column) {
        this.errorExist = false;
        boolean contin = this.Continue(Game.board);

        if (!contin) {
            if ((row >= 1 && row <= 3) && (column >= 1 && column <= 3)) {
                if (Game.board[row - 1][column - 1] == 'x' || Game.board[row - 1][column - 1] == 'o') {
                    this.errorExist = true;
                    this.errorMsg = "Error: slot @ (" + row + ", " + column + ") is already occupied.";
                }
                else {
                    this.row = row;
                    this.column = column;
                    this.turnInt++;
                }
            }
            else if  (row < 1 || row > 3){
                this.errorExist = true;
                this.errorMsg = "Error: row " + row + " is invalid.";
            }
            else if  (column < 1 || column > 3){
                this.errorExist = true;
                this.errorMsg = "Error: col " + column + " is invalid.";
            }
        }
        else  {
            this.errorExist = true;
            this.errorMsg = "Game is over with Suyeon being the winner.";
        }

    }

    // Helper Method
    public boolean Continue(char[][] a) {
        boolean winner = false;
        boolean stay = true;

        for (int i = 0; stay && i < a.length; i ++) {
            if (a[i][i] == 'x') {
                winner = true;
            }
            else {
                winner = false;
                stay = false;
            }
        }
        if (!winner) {
            stay = true;
            for (int i = 0; stay && i < a.length; i ++) {
                if (a[i][i] == 'o') {
                    winner = true;
                }
                else {
                    winner = false;
                    stay = false;
                }
            }
        }


//        for (int i = 0; i < a.length; i ++) {
//            char firstChar = 'x';
//            for (int m = 0; m < a[i].length; m ++) {
//                if ()
//            }
//        }
        return winner;
    }

}




















