package com.hunter;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private MineField mineField;
    private int[][] mineFieldToShow;
    private boolean isGameOver = false;
    private boolean isSuccess = false;
    private Set<String> pastMoves = new HashSet<>();


    Scanner scanner = new Scanner(System.in);

    public Game(MineField mineField) {
        this.mineField = mineField;
        this.mineFieldToShow = new int[mineField.getRow()][mineField.getColumn()];
        MineFieldCleaner.cleanFieldArray(mineFieldToShow);
    }

    // start the game and the loop which will run until isGameOver is true
    public void getStart() {
        while(!isGameOver) {
            getMove();
            checkGameState();
            System.out.println("========================");
        }
        System.out.println("Game is over");
        if(isSuccess) {
            System.out.println("you won");
        }
        else {
            System.out.println("you lost");
        }
    }

    // ask the player to say which row and column he will play on
    public void getMove() {
        System.out.print("row: ");
        int row = this.scanner.nextInt();
        System.out.print("column: ");
        int column = this.scanner.nextInt();
        if(row >= 0 && row < mineField.getRow() && column >= 0 && column < mineField.getColumn()) {
            if(pastMoves.contains(row + "." + column)) {
                // this move has been done by the player before
                System.out.println("you did this move before! try again");
            }
            else {
                pastMoves.add(row + "." + column);
                checkOutLand(row, column);
                MineFieldShower.showMineFieldArray(mineFieldToShow);
            }
        }
        else{
            System.out.println("invalid move! try again");
        }


    }

    // check the land that we are examining
    public void checkOutLand(int row, int column) {
        if(mineField.getMinefield()[row][column] == 0) {
            int mineAmount = checkOutAround(row, column);
            mineFieldToShow[row][column] = mineAmount;
        }
        else {
            isGameOver = true;
            isSuccess = false;
        }
    }

    // check the squares which are around of the land
    public int checkOutAround(int row, int column) {
        int mineCounter = 0;
        for(int i = row - 1; i <= row + 1; i++) {
            if(i >= 0 && i < mineField.getRow()) {
                for(int j = column - 1; j <= column + 1; j++) {
                    if(j >= 0 && j < mineField.getColumn()) {
                        if(mineField.getMinefield()[i][j] == 1) {
                            mineCounter++;
                        }
                    }
                }
            }
        }
        return mineCounter;
    }

    // check the game state
    public void checkGameState() {
        if(pastMoves.size() == mineField.getRow() * mineField.getColumn() - DecideAmount.decideMineAmount(mineField.getRow(),
            mineField.getColumn())) {
            isSuccess = true;
            isGameOver = true;
        }
    }
}
