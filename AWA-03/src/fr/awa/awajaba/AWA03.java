/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author developpeur
 */
public class AWA03 extends Application {
    
    public Label label = new Label("");
    public TextField textField = new TextField ();
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button ("Mettre en majusucule");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    label.setText(textField.getText().toUpperCase());
            }
        });
        VBox root = new VBox();
        root.getChildren().add(textField);
        root.getChildren().add(label);
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Texte :");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
