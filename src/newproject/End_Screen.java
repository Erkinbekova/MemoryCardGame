package newproject;

import javafx.scene.Parent;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class End_Screen {
    
    public static Pane root_end = new Pane();
    
    public static Text congo = new Text("");
    public static Text winner = new Text("");
    
    public Parent createContent_end() {
        root_end.setPrefSize(500.0, 300.0);
        createLabel(congo,270,100,20);
        createLabel(winner,180,200,15);
        return root_end;
    }
  
    public void createLabel(Text t,int x,int y, int z) {
        t.setTranslateX(x);
        t.setTranslateY(y);
        t.setFont(Font.font("Helvetica",FontWeight.EXTRA_BOLD, z));
        Effect glow = new Glow(0.5);
        t.setEffect(glow);
        t.setCache(true);
        t.setFill(Color.BLACK);
        root_end.getChildren().add(t);
    }
}
