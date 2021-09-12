package com.hunter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("input for row: ");
        int row = scanner.nextInt();
        System.out.print("input for column: ");
        int column = scanner.nextInt();

        MineField mineField = new MineField(row, column);

        MineFieldCleaner.cleanField(mineField);
        RandomMineSpawn.spawnMine(mineField);
        MineFieldShower.showMineField(mineField);

        Game game = new Game(mineField);
        game.getStart();
    }
}
