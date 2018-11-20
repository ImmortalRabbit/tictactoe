package OOP;

public class GameMainInterface {

    private Grid grid;
    private String player;

    public GameMainInterface() {
        this.player = "X";
        this.grid = new Grid();
    }

    public void sendCoordinates(int x, int y) throws IllegalArgumentException {

        Position position = new Position(x, y, this.player);
        try {
            grid.setElement(position);
            changePlayer();
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public String getPlayer() {
        return player;
    }

    public boolean IsThereWinner() {
        return grid.IsThereWinner("O") || grid.IsThereWinner("X");
    }

    private void changePlayer() {
        if (player.equals("X")) {
            player = "O";
        } else {
            player = "X";
        }
    }

    public boolean IsFull() {
        return grid.full();
    }

    public String whoIsWinner() {
        if (grid.IsThereWinner("O")) {
            return "O";
        }
        return "X";
    }

    public void clean() {
        grid.clean();
        player = "X";
    }

    public void printGrid() {
        System.out.println(grid);
    }
}
