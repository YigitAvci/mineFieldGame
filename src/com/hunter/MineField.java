package com.hunter;

public class MineField {

    private int row;
    private int column;

    private int[][] minefield;

    public MineField(int row, int column) {
        this.row = row;
        this.column = column;

        minefield = new int[row][column];
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int[][] getMinefield() {
        return minefield;
    }

}
