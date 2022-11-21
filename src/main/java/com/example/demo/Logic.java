package com.example.demo;

public class Logic {

    public int[][] gameBoard;

    public Logic() {
        gameBoard=new int[3][3];
    }

    public void clearBoard(){
        this.gameBoard=new int[3][3];
    }

    public boolean setValue(int y,int x, int player){
        if(gameBoard[y][x]!=0){
            return false;
        }
        else if (player ==1){
            gameBoard[y][x]=1;
            return true;
        }else{
            gameBoard[y][x]=2;
            return true;
        }
    }

    public boolean verifyWhoWon(){
        if((gameBoard[0][0]==1 && gameBoard[0][1]==1 &&gameBoard[0][2]==1) ||
                (gameBoard[1][0]==1 && gameBoard[1][1]==1 &&gameBoard[1][2]==1) ||
                (gameBoard[2][0]==1 && gameBoard[2][1]==1 &&gameBoard[2][2]==1) ||
                (gameBoard[0][0]==1 && gameBoard[1][1]==1 &&gameBoard[2][2]==1) ||
                (gameBoard[0][2]==1 && gameBoard[1][1]==1 &&gameBoard[2][0]==1) ||
                (gameBoard[0][0]==1 && gameBoard[1][0]==1 &&gameBoard[2][0]==1) ||
                (gameBoard[0][1]==1 && gameBoard[1][1]==1 &&gameBoard[2][1]==1) ||
                (gameBoard[0][2]==1 && gameBoard[1][2]==1 &&gameBoard[2][2]==1) ){
            return true;
        }else return (gameBoard[0][0] == 2 && gameBoard[0][1] == 2 && gameBoard[0][2] == 2) ||
                (gameBoard[1][0] == 2 && gameBoard[1][1] == 2 && gameBoard[1][2] == 2) ||
                (gameBoard[2][0] == 2 && gameBoard[2][1] == 2 && gameBoard[2][2] == 2) ||
                (gameBoard[0][0] == 2 && gameBoard[1][1] == 2 && gameBoard[2][2] == 2) ||
                (gameBoard[0][2] == 2 && gameBoard[1][1] == 2 && gameBoard[2][0] == 2) ||
                (gameBoard[0][0] == 2 && gameBoard[1][0] == 2 && gameBoard[2][0] == 2) ||
                (gameBoard[0][1] == 2 && gameBoard[1][1] == 2 && gameBoard[2][1] == 2) ||
                (gameBoard[0][2] == 2 && gameBoard[1][2] == 2 && gameBoard[2][2] == 2);
    }
}