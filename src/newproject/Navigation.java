package newproject;

import javafx.application.Application;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Navigation extends Application {
    public static Stage GameStage;
    Scene Main;
    Scene Game;
    public static Scene End;
    Button start;
    Button back;
    Button stopGame;
    Button jumpToMain;
    Button exit;

    Parent root_main;
    Parent root_game;
    Parent root_end;

    public void createStartButton() {
        start = new Button("START");
        start.setTranslateX(36);
        start.setTranslateY(140);
        start.setOnAction(e -> handleButtonAction(e));
    }
    
    public void createBackButton() {
        back = new Button("BACK");
        back.setTranslateX(550);
        back.setTranslateY(15);
        back.setOnAction(e -> handleButtonAction(e));
    }
    
    public void createStopButton() {
        
        stopGame = new Button("STOP");
        stopGame.setTranslateX(400);
        stopGame.setTranslateY(15);
        stopGame.setOnAction(e -> handleButtonAction(e));
    }
    

    public void handleButtonAction(ActionEvent event) {
        if (event.getTarget() == start) {
           
            Game_Screen game_ob = new Game_Screen();
            root_game = game_ob.createContent();
            createBackButton();
            createStopButton();
            ((Pane)root_game).getChildren().addAll(back, stopGame);
            Game = new Scene(root_game, 1000.0, 670.0);
            GameStage.setScene(Game);
            
        } else if (event.getTarget() == stopGame) {
            if (((Game_Screen.P1_score) + (Game_Screen.P2_score)) == 0) {
            
                End_Screen.winner.setText("The game is stopped!");
            } else {
                //End_Screen.congo.setText("Вы остановили игру!");
                End_Screen.winner.setText("First player has: "+(Game_Screen.P1_score)*10+" points.\n"+"Second player has: "+(Game_Screen.P2_score)*10+" points.");
            }
            GameStage.setScene(End);
            GameStage.setFullScreen(false);
          
            
        } 
          else if(event.getTarget() == back){
                    GameStage.setScene(Main);
                    }
          else if (event.getTarget() == exit) {
            exit();
        }
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GameStage = primaryStage;
        //Main Scene starts here
        Main_Screen main_ob = new Main_Screen();
        root_main = main_ob.createContent_new();
        createStartButton();
        ((Pane)root_main).getChildren().add(start);
        Main = new Scene(root_main, 100.0, 270.0);  
        
        //End Scene starts here
        End_Screen end_ob = new End_Screen();
        root_end = end_ob.createContent_end();
        End = new Scene(root_end, 600.0, 400.0);
        
        GameStage.setScene(Main);
        GameStage.show();
        GameStage.setTitle("Memory Game");
        GameStage.setFullScreen(false);
    }
   
    public static void main (String[] args) {
        launch(args);
    }
}
