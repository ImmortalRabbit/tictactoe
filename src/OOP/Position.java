package OOP;

import java.util.Scanner;

public class Position {
    private int x;
    private int y;
    private String player;

    Position(String player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Player \'%s\', enter your move (row[1-3] column[1-3]):", player));
        String[] inputArray = scanner.nextLine().split(" ");
        this.x = Integer.parseInt(inputArray[0]) - 1;
        this.y = Integer.parseInt(inputArray[1]) - 1;
        this.player = player;
    }

    Position(int x, int y, String player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    int getY() {
        return y;
    }

    int getX() {
        return x;
    }

    public String toString() {
        return this.player;
    }
}