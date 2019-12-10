/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author developpeur
 */
public class AWA02 extends Application {
    
    public int i = 0;
    public Label lblValeur = new Label(String.valueOf(i));
    
    @Override
    public void start(Stage primaryStage) {
        Button btnInc = new Button ("Incrémenter");
        Button btnQuitter = new Button("Quitter");
        btnQuitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        btnInc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    i++;
                    lblValeur.setText(String.valueOf(i));
            }
        });
        VBox root = new VBox();
        root.getChildren().add(lblValeur);
        root.getChildren().add(btnInc);
        root.getChildren().add(btnQuitter);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("AWA-VBox");
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
