// import java.io.File;
// import java.util.Scanner;

import java.sql.Time;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
// import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class App extends Application {
    
    public void start(Stage stage) {
        Course c0 = new Course("ICS104");
        Course c1 = new Course("IAS212");

        Section [] availablSection = new Section[2];
        availablSection[0] = new Section(c0,11111,"01","56-212","UT","0800-0850");
        availablSection[1] = new Section(c1);



        StackPane sPane = new StackPane();
        
        BorderPane grid = new BorderPane();
        // grid.setHgap(20);
        // grid.setVgap(20);
        grid.setPadding(new Insets(0, 10, 0, 10));
        Button useOldSave = new Button("Start with a\nsaved scheduel");
        Button next = new Button("next");
        VBox sections = sectionsVBox(availablSection);
        Text title = new Text("Add sections to basket");
        title.setFont(new Font("Arial", 30));
        Shape rec= new Rectangle();
        rec.setFill(Color.RED);
        rec.setStroke(Color.BLACK);


        // RowConstraints row1 = new RowConstraints();
        // RowConstraints row2 = new RowConstraints();
        // RowConstraints row3 = new RowConstraints();
        // ColumnConstraints col1 = new ColumnConstraints();
        // ColumnConstraints col2 = new ColumnConstraints();
        // ColumnConstraints col3 = new ColumnConstraints();
        // grid.getRowConstraints().add(row1);
        // grid.getRowConstraints().add(row2);
        // grid.getRowConstraints().add(row3);
        // grid.getColumnConstraints().add(col1);
        // grid.getColumnConstraints().add(col2);
        // grid.getColumnConstraints().add(col3);

        // row1.setPercentHeight(15);
        // row2.setPercentHeight(75);
        // row3.setPercentHeight(10);
        // col1.setPercentWidth(20);
        // col2.setPercentWidth(60);
        // col3.setPercentWidth(20);


        sPane.getChildren().addAll(rec,sections);
        grid.setTop(title);
        // grid.setTop(useOldSave);
        grid.setCenter(sPane);
        
        






        Scene scene = new Scene(grid,800,600);
        stage.setScene(scene);
        stage.setTitle("hELLI");
        stage.show();

    }
    private static VBox sectionsVBox(Section [] sections){
        VBox vBox = new VBox();
        for(Section sec : sections){
            Label label = new Label(sec.toString());
            Button addBt = new Button("Add");
            Button delBt = new Button("Del");
            HBox hbox = new HBox();
            
            hbox.getChildren().addAll(label,addBt,delBt);
            hbox.setSpacing(10);
            vBox.getChildren().add(hbox);
        }
        
        
        
        
        return vBox;
    }
    public static void main(String[] args) {
        launch();
            

        }


}

  


