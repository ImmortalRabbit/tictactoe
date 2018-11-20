package taskA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int win = 0;
        String playerX = "X";
        String playerO = "O";
        int player = 1;
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
        int[] coord;
        while (win == 0) {

            if(IsBoardFull(board)){
                player = 2;
                break;
            }

            if (player == 1) {
                coord = player(playerX);
                int x = coord[0] - 1;
                int y = coord[1] - 1;
                if ((board[x][y].equals(playerO)) || (board[x][y].equals(playerX))) {
                    System.out.println(String.format("This move at (%d,%d) is not valid. Try again...", coord[0], coord[1]));
                } else {
                    board[x][y] = playerX;
                    win = IsThereWinner(board, playerX);
                    player = 0;
                }
            } else {
                coord = player(playerO);
                int x = coord[0] - 1;
                int y = coord[1] - 1;
                if ((board[x][y].equals(playerO)) || (board[x][y].equals(playerX))) {
                    System.out.println(String.format("This move at (%d,%d) is not valid. Try again...", coord[0], coord[1]));
                } else {
                    board[x][y] = playerO;
                    win = IsThereWinner(board, playerO);

                    player = 1;
                }
            }

            printBoard(board);
        }

        if (player == 0) {
            System.out.println(String.format("Player \'%s\' won!", playerX));
        } else if (player == 1) {
            System.out.println(String.format("Player \'%s\' won!", playerO));
        } else {
            System.out.println("DRAW");
        }
    }

    private static boolean IsBoardFull(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j].equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] player(String x) {
        Scanner scanner = new Scanner(System.in);
        String out = String.format("Player \'%s\', enter your move (row[1-3] column[1-3]):", x);
        System.out.println(out);
        int[] coordinates = new int[2];
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        coordinates[0] = Integer.parseInt(inputArray[0]);
        coordinates[1] = Integer.parseInt(inputArray[1]);
        return coordinates;

    }

    private static void printBoard(String[][] board) {
        System.out.println(String.format(" %s | %s | %s ", board[0][0], board[0][1], board[0][2]));
        System.out.println("-----------");
        System.out.println(String.format(" %s | %s | %s ", board[1][0], board[1][1], board[1][2]));
        System.out.println("-----------");
        System.out.println(String.format(" %s | %s | %s ", board[2][0], board[2][1], board[2][2]));
    }

    private static int IsThereWinner(String[][] board, String player) {
        String[] case1 = {board[0][0], board[0][1], board[0][2]};
        String[] case2 = {board[1][0], board[1][1], board[1][2]};
        String[] case3 = {board[2][0], board[2][1], board[2][2]};
        String[] case4 = {board[0][0], board[1][0], board[2][0]};
        String[] case5 = {board[0][1], board[1][1], board[2][1]};
        String[] case6 = {board[0][2], board[1][2], board[2][2]};
        String[] case7 = {board[0][0], board[1][1], board[2][2]};
        String[] case8 = {board[0][2], board[1][1], board[2][0]};
        String[][] cases = {case1, case2, case3, case4, case5, case6, case7, case8};
        for (String[] check : cases) {
            if (AreTheyEqual(player, check)) {
                return 1;
            }
        }
        return 0;
    }

    private static boolean AreTheyEqual(String player, String[] check) {
        for (int i = 0; i < 3; i++) {
            if (!player.equals(check[i])) {
                return false;
            }
        }
        return true;
    }
}
