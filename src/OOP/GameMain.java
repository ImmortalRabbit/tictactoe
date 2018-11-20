package OOP;

public class GameMain {

    private Grid grid = new Grid();
    private String player;

    public GameMain() {
        this.player = "X";
    }

    public void playGame() {
        while (true) {
            Position position = new Position(this.player);

            if (this.grid.full()){
                System.out.println("DRAW");
                break;
            }
            try {
                this.grid.setElement(position);
                System.out.println(this.grid);

                if (this.grid.IsThereWinner(this.player)) {
                    System.out.println(String.format("Player \'%s\' won!", player));
                    break;
                }

                changePlayer();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    private void changePlayer() {
        if (player.equals("X")) {
            player = "O";
        } else {
            player = "X";
        }
    }
}