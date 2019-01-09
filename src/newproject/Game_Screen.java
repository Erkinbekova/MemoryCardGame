package newproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.image.*;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Game_Screen {
    List<Tile> tiles = new ArrayList<>();
   //double tiles [][] = new double [4][4]; 
    public static String x = "Harry Potter";
    public static String y = "4";
    public Color color = Color.STEELBLUE;
    
    public static int P1_score = 0, P2_score = 0, click_count = 0;
    Text score1 = new Text();
    Text score2 = new Text();
    Text turn = new Text();
    
    public Tile selected = null;
    public int clickCount = 2;

    Pane root_game = new Pane();
   
    public Game_Screen() {
        
        createLabelPlayer("Player 1",35,120);
        createLabelPlayer("Player 2",820,120);
        createLabelScore(score1,80,175);
        createLabelScore(score2,880,175);
        createHintButton();
        createHintButton1();
       // createResetButton();
       // createLabelTurn();
        turn.setText("1-st player`s turn");
        score1.setText(Integer.toString(0));
        score2.setText(Integer.toString(0));

    }
    
    public int NOP() {
        int i = (Integer.parseInt(y) * Integer.parseInt(y)) / 2;
        return i;
    }
    
    public int NPR() {
        int i = Integer.parseInt(y);
        return i;
    }
    
    public void ColorSetter() {
       switch (x) {
            case "Harry Potter":
                color = Color.GREY;
                break;
        }
    }
    
    public Parent createContent() { 
        root_game.setPrefSize(820.0, 600.0);
        ColorSetter();
        
        for (int i = 1; i <= NOP(); i++) {
            Image img = new Image("/newproject/Images/"+x+"/"+i+".jpg",600/NPR(),600/NPR(),false,true);
            tiles.add(new Tile(img));
            tiles.add(new Tile(img));
        }

        Collections.shuffle(tiles);
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            tile.setTranslateX(195 + (600/NPR()) * (i % NPR()));
            tile.setTranslateY(50 + (600/NPR()) * (i / NPR()));
            root_game.getChildren().add(tile);
        }
        P1_score = 0;
        P2_score = 0;
        click_count = 0;
//        createResetButton();       
        return root_game;
    }


    public final void createLabelPlayer(String pl,int x,int y) {
        Text t = new Text(pl);
        t.setTranslateX(x);
        t.setTranslateY(y);
        t.setFill(Color.BLACK);
        t.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 35));
        root_game.getChildren().addAll(t);
    }
    
    public final void createLabelScore(Text t,int x,int y) {
        t.setTranslateX(x);
        t.setTranslateY(y);
        t.setCache(true);
        t.setFill(Color.BLACK);
        t.setFont(Font.font(null, FontWeight.BOLD, 30));
        root_game.getChildren().add(t);
    }
//    public final void createLabelTurn() {
//        turn.setTranslateX(580);
//        turn.setTranslateY(30);
//        turn.setFill(Color.BLACK);
//        turn.setFont(Font.font(null, FontWeight.BOLD, 25));
//        root_game.getChildren().add(turn);
//    }
    
//    public void createResetButton() {
//        Button rbt = new Button("НАЧАТЬ ЗАНОВО");
//        rbt.setTranslateX(100);
//        rbt.setTranslateY(600);
//        
//        rbt.setOnAction((ActionEvent event) -> {
//            score1.setText(Integer.toString(0));
//            score2.setText(Integer.toString(0));
//            turn.setText("Ход игрока 1");
//            createContent();
//        });
//        root_game.getChildren().add(rbt);
//    }
    
   public void createHintButton() {
        Button hnt = new Button("HINT");
        hnt.setTranslateX(65);
        hnt.setTranslateY(300);
        
        hnt.setOnAction((ActionEvent event) -> {
            if (selected != null) {
                for (int i = 0; i < tiles.size(); i++) { 
                    //System.out.println(tiles.get(i).click_flag);
                    if (selected.hasSameValue(tiles.get(i)) && !tiles.get(i).click_flag  ) { 
                        tiles.get(i).img.setOpacity(1);
                         if(tiles.get(i-1).click_flag==false && tiles.get(i+1).click_flag==false){
                        tiles.get(i-1).img.setOpacity(1);
                        tiles.get(i+1).img.setOpacity(1);
                       
                        tiles.get(i-1).close();
                        tiles.get(i+1).close();
                    }
                           tiles.get(i).close();
                }
//for (int i=0; i<tiles.size();i++){
//    for (int j=0;j<tiles.size();i++){
//        if (tiles[i][j])
//    }
//}
                }
            }
//             hnt.setVisible(false);         
            hnt.setDisable(true);
            //createContent();
        });
        root_game.getChildren().add(hnt);
    }
   
   
   
   
//   public class Tile : MonoBehaviour {
//    public List<Tile> neighbours = new ArrayList<Tile> ();
//    //public CircleCollider2D col2d;
//    // Use this for initialization
//    void Start () {
//        FindNeighbours ();
//    }
//   
//    // Update is called once per frame
//    void Update () {
//       
//    }
// 
////    void FindNeighbours(){
////        Tile[] tiles = FindObjectsOfType<Tile> ();
//// 
////        foreach (Tile tile in tiles) {
////            if (tile.gameObject.GetInstanceID() != gameObject.GetInstanceID()) {
////                if (col2d.bounds.Intersects (tile.gameObject.GetComponent<Collider2D> ().bounds)) {
////                    Debug.Log ("[" + gameObject.name + "] found a neighbour: " + tile.gameObject.name);
////                    neighbours.Add (tile.gameObject);
////                }
////            }
////        }
//// 
////    }
//}
//   
   
  public void createHintButton1() {
        Button hnt1 = new Button("HINT");
        hnt1.setTranslateX(865);
        hnt1.setTranslateY(300);
        
        hnt1.setOnAction((ActionEvent event) -> {
            if (selected != null) {
                for (int i = 0; i < tiles.size(); i++) { 
                    //System.out.println(tiles.get(i).click_flag);
                    if (selected.hasSameValue(tiles.get(i)) && !tiles.get(i).click_flag  ) { 
                        tiles.get(i).img.setOpacity(1);
                        if(tiles.get(i-1).click_flag==false && tiles.get(i+1).click_flag==false){
                        tiles.get(i-1).img.setOpacity(1);
                        tiles.get(i+1).img.setOpacity(1);
                        tiles.get(i-1).close();
                        tiles.get(i+1).close();
                    }
                        tiles.get(i).close();
                }
            }
            }
//            hnt1.setVisible(false);
            hnt1.setDisable(true);
            //createContent();
        });
        root_game.getChildren().add(hnt1);
    }

    public final class Tile extends StackPane {
        
        boolean click_flag = false;
        ImageView img;
        Image image;
        public Tile(Image image) {
            this.image = image;
            Rectangle border = new Rectangle(600/NPR(), 600/NPR());
            img = new ImageView();
            img.setImage(image);
            border.setFill(color);
            border.setStroke(Color.BLACK);
            getChildren().addAll(border,img);
            setOnMouseClicked(this::handleMouseClick);
            close();
        }
        
        public void handleMouseClick(MouseEvent event) {
            if (click_flag == true) {
                
            } else {
                click_count++;
                if (((click_count) % 4) == 0) {
                    turn.setText("1-st player`s turn");   
                } else if (((click_count) % 2) == 0) {
                    turn.setText("2-nd player`s turn");   
                }
                if (isOpen() || clickCount == 0) {               
                    return;
                }
                clickCount--;

                if (selected == null) {
                    selected = this;
                    open(() -> {});
                }
                else {
                    open(() -> {
                        if (!hasSameValue(selected)) {
                            selected.close();
                            this.close();
                        }

                        selected = null;
                        clickCount = 2;
                    });
                }
            }               
        }         

        public boolean isOpen() {
            return img.getOpacity() == 1;
        }
        
        public void open(Runnable ac) {
            click_flag = true;
            FadeTransition ft = new FadeTransition(Duration.seconds(0.1), img);
            ft.setToValue(1);
            ft.setOnFinished(e -> ac.run());
            ft.play();
        }

        public void close_start() {
            FadeTransition ft = new FadeTransition(Duration.seconds(NPR()), img);
            ft.setToValue(0);
            ft.play();
        }
        
        public void close() {
            click_flag = false;
            FadeTransition ft = new FadeTransition(Duration.seconds(0.1), img); 
            ft.setToValue(0);
            ft.play();
        }

        public boolean hasSameValue(Tile other) {
            if ((image.equals(other.image)) && ((click_count) % 4) == 0) {
                P2_score++;
                score2.setText(Integer.toString(P2_score * 10));
            } else if ((image.equals(other.image)) && ((click_count) % 2) == 0) {
                P1_score++;
                score1.setText(Integer.toString(P1_score * 10));
            }
            if ((P1_score + P2_score) == NOP()) {
                if (P1_score > P2_score) {
                    End_Screen.winner.setText("1-st player won by "+(P1_score-P2_score) * 10+" points.");
                } else if (P1_score < P2_score) {
                    End_Screen.winner.setText("2-nd player won by "+(P2_score-P1_score) * 10+" points.");
                } else {
         
                    End_Screen.winner.setText("Draw!");
                }
                Navigation.GameStage.setScene(Navigation.End);
            }
            return image.equals(other.image); 
        }
    }
}