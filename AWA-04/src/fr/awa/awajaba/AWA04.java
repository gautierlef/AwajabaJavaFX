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
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.HPos;

/**
 *
 * @author developpeur
 */
public class AWA04 extends Application {
    
    public TextField textFieldId = new TextField ();
    public PasswordField passwordFieldMdp = new PasswordField ();
    
    @Override
    public void start(Stage primaryStage) {
        Label lblId = new Label("Identifiant : ");
        Label lblMdp = new Label("Mot de passe : ");
        Button btnAnnuler = new Button ("Annuler");
        btnAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    textFieldId.setText("");
                    passwordFieldMdp.setText("");
            }
        });
        Button btnValider = new Button ("Valider");
        btnValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if ("administrateur".equals(textFieldId.getText()) && "azerty".equals(passwordFieldMdp.getText())) {
                    Alert dlgNok = new Alert (AlertType.INFORMATION);
                    dlgNok.setTitle ("Authentification");
                    dlgNok.setHeaderText("Authentification réussi !");
                    dlgNok.setContentText("Bienvenue!");
                    dlgNok.showAndWait();
                }
                else {
                    Alert dlgNok = new Alert (AlertType.ERROR);
                    dlgNok.setTitle ("Authentification");
                    dlgNok.setHeaderText("Authentification échouée !");
                    dlgNok.setContentText("Identifiant ou mot de passe incorrect!");
                    dlgNok.showAndWait();
                }
            }
        });
        GridPane root = new GridPane();
        root.add(textFieldId, 1, 0);
        root.add(passwordFieldMdp, 1, 1);
        root.add(lblId, 0, 0);
        root.add(lblMdp, 0, 1);
        root.add(btnAnnuler, 0, 2);
        root.add(btnValider, 1, 2);
        root.setHalignment(btnAnnuler, HPos.RIGHT);
        root.setHalignment(btnValider, HPos.RIGHT);
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(25);
        Scene scene = new Scene(root, 380, 165);
        primaryStage.setTitle("Authentification :");
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
