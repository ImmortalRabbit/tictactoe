package OOP;

public class Grid {
    private String[][] board;

    Grid() {
        this.board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = " ";
            }
        }
    }

    void setElement(Position element) throws IllegalArgumentException {
        if ((this.board[element.getX()][element.getY()].equals("X")) || this.board[element.getX()][element.getY()].equals("O")) {
            throw new IllegalArgumentException("This move is not valid.");
        }
        this.board[element.getX()][element.getY()] = String.valueOf(element);
    }

    boolean IsThereWinner(String player) {
        String[] case1 = {this.board[0][0], this.board[0][1], this.board[0][2]};
        String[] case2 = {this.board[1][0], this.board[1][1], this.board[1][2]};
        String[] case3 = {this.board[2][0], this.board[2][1], this.board[2][2]};
        String[] case4 = {this.board[0][0], this.board[1][0], this.board[2][0]};
        String[] case5 = {this.board[0][1], this.board[1][1], this.board[2][1]};
        String[] case6 = {this.board[0][2], this.board[1][2], this.board[2][2]};
        String[] case7 = {this.board[0][0], this.board[1][1], this.board[2][2]};
        String[] case8 = {this.board[0][2], this.board[1][1], this.board[2][0]};
        String[][] cases = {case1, case2, case3, case4, case5, case6, case7, case8};

        for (String[] check : cases) {
            if (AreTheyEqual(player, check)) {
                return true;
            }
        }
        return false;
    }

    private static boolean AreTheyEqual(String X, String[] check) {
        for (int i = 0; i < 3; i++) {
            if (!X.equals(check[i])) {
                return false;
            }
        }
        return true;
    }


    boolean full() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    void clean() {
        this.board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = " ";
            }
        }
    }

    public String toString() {
        return String.format(" %s | %s | %s ", board[0][0], board[0][1], board[0][2]) + "\n" + "-----------" + "\n"
                + String.format(" %s | %s | %s ", board[1][0], board[1][1], board[1][2]) + "\n" + "-----------" + "\n"
                + String.format(" %s | %s | %s ", board[2][0], board[2][1], board[2][2]);
    }
}
