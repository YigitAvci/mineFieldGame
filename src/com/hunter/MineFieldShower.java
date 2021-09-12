package com.hunter;

public class MineFieldShower {

    public static void showMineField(MineField mineField) {
        int row = mineField.getRow();
        int column = mineField.getColumn();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(mineField.getMinefield()[i][j] == 0) {
                    System.out.print("-" + " ");
                }
                else {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void showMineFieldArray(int[][] mineField) {
        int row = mineField.length;
        int column = mineField[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(mineField[i][j] != -1) {
                    System.out.print(mineField[i][j] + " ");
                }
                else {
                    System.out.print("-" + " ");
                }
            }
            System.out.println();
        }
    }
}
