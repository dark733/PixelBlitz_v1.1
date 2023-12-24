package com.example.fxml_manual;

import javafx.stage.Stage;

abstract class game_two_i{
    static void game_two_event() {
    }
}

class game_two extends game_two_i{
    public final int MOVE =25;
    public static final int SIZE =25;
    public static final int XMAX =SIZE*12;
    public static final int YMAX =SIZE*24;
    private static int[][] MESH = new int[XMAX/SIZE][YMAX/SIZE];
    public static void game_two_event() {
        Stage stage = new Stage();
        System.out.println("Initialising game Two");
        //Game Two Implemented here
        if(stage!=null){
            System.out.println("Stage is not null");
            tetris_game(stage);
        }
        else{
            System.out.println("Stage is Null(Stage is void)");
        }

    }
    public static void tetris_game(Stage stage){

    }
}
