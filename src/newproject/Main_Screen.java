package newproject;

import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main_Screen {
    
    public static VBox root_main = new VBox();
    
    public Parent createContent_new() {

        root_main.setPrefSize(1000.0, 600.0);

        createText2();
        createRadioButton2();
        return root_main;
    }
    
    public static void createText2() {
        Text t2 = new Text("DIFFICALTY:");
        t2.setTranslateX(10);
        t2.setTranslateY(20);
        t2.setFont(Font.font("Helvetica", 18));
        root_main.getChildren().add(t2);
    }
    
    
    public static void createRadioButton2() {
       final ToggleGroup group = new ToggleGroup();

       RadioButton rb1 = new RadioButton("Easy");
       rb1.setFont(Font.font(null, 14));
       rb1.setToggleGroup(group);
       rb1.setUserData("4");

       RadioButton rb2 = new RadioButton("Medium");
       rb2.setFont(Font.font(null, 14));
       rb2.setToggleGroup(group);
       rb2.setUserData("6");
       
       RadioButton rb3 = new RadioButton("Hard");
       rb3.setFont(Font.font(null, 14));
       rb3.setToggleGroup(group);
       rb3.setUserData("8");

       group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
           if (group.getSelectedToggle() != null) {
               Game_Screen.y = group.getSelectedToggle().getUserData().toString();
           }
       });
       
       rb1.setTranslateX(10);
       rb1.setTranslateY(50);
       
       rb2.setTranslateX(10);
       rb2.setTranslateY(80);
       
        rb3.setTranslateX(10);
       rb3.setTranslateY(110);
       root_main.getChildren().addAll(rb1, rb2,rb3);
       
       rb1.setSelected(true);
       rb1.requestFocus();
    }
}