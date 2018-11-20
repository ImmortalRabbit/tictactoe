package TaskC;

import OOP.GameMainInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private Button button1 = new Button(" ");
    private Button button2 = new Button(" ");
    private Button button3 = new Button(" ");
    private Button button4 = new Button(" ");
    private Button button5 = new Button(" ");
    private Button button6 = new Button(" ");
    private Button button7 = new Button(" ");
    private Button button8 = new Button(" ");
    private Button button9 = new Button(" ");

    private String player = "X";
    private GameMainInterface gameMain = new GameMainInterface();
    private Text text = new Text("Tic Tac Toe");

    @Override
    public void start(Stage primaryStage) {


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(300, 300);
        gridPane.setPadding(new Insets(0, 0, 0, 0));

        gridPane.add(button1, 0, 0);
        gridPane.add(button2, 1, 0);
        gridPane.add(button3, 2, 0);
        gridPane.add(button4, 0, 1);
        gridPane.add(button5, 1, 1);
        gridPane.add(button6, 2, 1);
        gridPane.add(button7, 0, 2);
        gridPane.add(button8, 1, 2);
        gridPane.add(button9, 2, 2);

        gridPane.add(text, 0, 10);

        text.setStyle("-fx-min-width: 150px; -fx-min-height: 50px");

        button1.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-min-height: 200px; -fx-min-width: 200px; -fx-font-size: 72px");
        button2.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-min-height: 200px; -fx-min-width: 200px; -fx-font-size: 72px");
        button3.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-min-height: 200px; -fx-min-width: 200px; -fx-font-size: 72px");
        button4.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-min-height: 200px; -fx-min-width: 200px; -fx-font-size: 72px");
        button5.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-min-height: 200px; -fx-min-width: 200px; -fx-font-size: 72px");
        button6.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-min-height: 200px; -fx-min-width: 200px; -fx-font-size: 72px");
        button7.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-min-height: 200px; -fx-min-width: 200px; -fx-font-size: 72px");
        button8.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-min-height: 200px; -fx-min-width: 200px; -fx-font-size: 72px");
        button9.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-min-height: 200px; -fx-min-width: 200px; -fx-font-size: 72px");

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkConditions(0, 0)) {
                    button1.setText(player);
                    changePlayer();
                }
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkConditions(0, 1)) {
                    button2.setText(player);
                    changePlayer();
                }
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (checkConditions(0, 2)) {
                    button3.setText(player);
                    changePlayer();
                }
            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (checkConditions(1, 0)) {
                    button4.setText(player);
                    changePlayer();
                }
            }
        });

        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (checkConditions(1, 1)) {
                    button5.setText(player);
                    changePlayer();
                }
            }
        });

        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkConditions(1, 2)) {
                    button6.setText(player);
                    changePlayer();
                }
            }
        });

        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (checkConditions(2, 0)) {
                    button7.setText(player);
                    changePlayer();
                }
            }
        });

        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (checkConditions(2, 1)) {
                    button8.setText(player);
                    changePlayer();

                }
            }
        });

        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (checkConditions(2, 2)) {
                    button9.setText(player);
                    changePlayer();
                }
            }
        });

        text.setStyle("-fx-font: normal bold 12px 'serif';");
        gridPane.setStyle("-fx-background-color: WHITE;");

        Scene scene = new Scene(gridPane);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private boolean checkConditions(int x, int y) {
        if (gameMain.IsFull() || gameMain.IsThereWinner()) {
            gameMain.clean();
            clean();
            return false;
        } else {
            try {
                gameMain.sendCoordinates(x, y);
                text.setText(String.format("Player \'%s\', your move:", gameMain.getPlayer()));
                if (gameMain.IsThereWinner()) {
                    text.setText(String.format("Player \'%s\' won!", gameMain.whoIsWinner()));
                }
            } catch (Exception ex) {
                text.setText(ex.getMessage());
                return false;
            }
        }
        gameMain.printGrid();
        return true;
    }

    private void clean() {
        button1.setText(" ");
        button2.setText(" ");
        button3.setText(" ");
        button4.setText(" ");
        button5.setText(" ");
        button6.setText(" ");
        button7.setText(" ");
        button8.setText(" ");
        button9.setText(" ");
        player = "X";
        text.setText(String.format("Player \'%s\', your move:", player));
    }

    private void changePlayer() {
        if (player.equals("X")) {
            player = "O";
        } else {
            player = "X";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
