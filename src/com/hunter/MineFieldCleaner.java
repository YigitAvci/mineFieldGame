package com.hunter;

public class MineFieldCleaner {

    public static void cleanField(MineField mineField) {

        for(int i = 0; i < mineField.getRow(); i++) {

            for (int j = 0; j < mineField.getColumn(); j++) {

                mineField.getMinefield()[i][j] = 0;
            }
        }
    }

    public static void cleanFieldArray(int[][] mineField) {

        for(int i = 0; i < mineField.length; i++) {

            for (int j = 0; j < mineField[0].length; j++) {

                mineField[i][j] = -1;
            }
        }
    }
}
