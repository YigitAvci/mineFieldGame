package com.hunter;

import java.util.HashSet;
import java.util.Set;

public class RandomMineSpawn {

    public static void spawnMine(MineField mineField) {
        int mineAmount = DecideAmount.decideMineAmount(mineField.getRow(), mineField.getColumn());
        plantMines(mineField, mineAmount);
    }


    private static void plantMines(MineField mineField, int mineAmount) {
        Set<String> lands = new HashSet<>();
        int i = mineAmount;
        while(i > 0) {
            int mineRow = (int) (Math.random() * (mineField.getRow()));
            int mineColumn = (int) (Math.random() * (mineField.getColumn()));

            if(lands.contains(mineRow + "." + mineColumn)) {
                // do not anything and let the while loop to continue
            }
            else {
                lands.add(mineRow + "." + mineColumn);
                mineField.getMinefield()[mineRow][mineColumn] = 1;
                i--;
            }
        }
    }

}
