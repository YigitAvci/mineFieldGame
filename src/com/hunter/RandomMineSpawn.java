package com.hunter;

public class RandomMineSpawn {

    public static void spawnMine(MineField mineField) {
        int mineAmount = DecideAmount.decideMineAmount(mineField.getRow(), mineField.getColumn());
        plantMines(mineField, mineAmount);
    }


    private static void plantMines(MineField mineField, int mineAmount) {
        for(int i = mineAmount; i > 0; i--) {
            int mineRow = (int) (Math.random() * (mineField.getRow()));
            int mineColumn = (int) (Math.random() * (mineField.getColumn()));

            mineField.getMinefield()[mineRow][mineColumn] = 1;
        }
    }

}
