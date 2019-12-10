/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import fr.awa.awajaba.entites.EvaluationRepas;
import fr.awa.awajaba.modeles.ModeleAwajaba;
import javafx.application.Application;
import javafx.application.Platform;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author developpeur
 */
public class AWA05 extends Application {
    
    public TextArea textAreaCommentaire = new TextArea();
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        ToggleGroup groupRB = new ToggleGroup();
        RadioButton rB0 = new RadioButton("0\t");
        rB0.setToggleGroup(groupRB);
        rB0.setUserData(0);
        RadioButton rB1 = new RadioButton("1\t");
        rB1.setToggleGroup(groupRB);
        rB1.setUserData(1);
        RadioButton rB2 = new RadioButton("2\t");
        rB2.setToggleGroup(groupRB);
        rB2.setUserData(2);
        RadioButton rB3 = new RadioButton("3\t");
        rB3.setToggleGroup(groupRB);
        rB3.setUserData(3);
        RadioButton rB4 = new RadioButton("4\t");
        rB4.setToggleGroup(groupRB);
        rB4.setUserData(4);
        RadioButton rB5 = new RadioButton("5\t");
        rB5.setToggleGroup(groupRB);
        rB5.setUserData(5);
        groupRB.selectToggle(rB0);
        Button btnAnnuler = new Button ("Annuler");
        btnAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textAreaCommentaire.setText("");
                groupRB.selectToggle(rB0);
            }
        });
        Button btnValider = new Button ("Valider");
        btnValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textAreaCommentaire.getText() == null || "".equals(textAreaCommentaire.getText())) {
                    Alert dlgNok = new Alert (AlertType.ERROR);
                    dlgNok.setTitle ("Erreur");
                    dlgNok.setHeaderText("Erreur de saisie :");
                    dlgNok.setContentText("Veuillez rentrer un commentaire!");
                    dlgNok.showAndWait();
                }
                else {
                    ModeleAwajaba modele = new ModeleAwajaba(new EvaluationRepas(Integer.parseInt(groupRB.getSelectedToggle().getUserData().toString().trim()), textAreaCommentaire.getText()));
                    System.out.println("Evaluation ajoutée :\nNote : " + modele.getEvalRepas().getNote() + "\nCommentaire : " + modele.getEvalRepas().getCommentaire());
                    Alert dlgNok = new Alert (AlertType.INFORMATION);
                    dlgNok.setTitle ("Succès");
                    dlgNok.setHeaderText("Evaluation ajoutée avec succès :");
                    dlgNok.setContentText("Note : " + modele.getEvalRepas().getNote() + "\nCommentaire : " + modele.getEvalRepas().getCommentaire());
                    dlgNok.showAndWait();
                    Platform.exit();
                }
            }
        });
        HBox radioLine = new HBox();
        Label labelEval = new Label("Evaluer votre repas :");
        labelEval.setStyle("-fx-font-weight: bold; -fx-underline: true;");
        root.add(labelEval, 0, 0);
        radioLine.getChildren().add(new Label("Note :\t"));
        radioLine.getChildren().add(rB0);
        radioLine.getChildren().add(rB1);
        radioLine.getChildren().add(rB2);
        radioLine.getChildren().add(rB3);
        radioLine.getChildren().add(rB4);
        radioLine.getChildren().add(rB5);
        root.add(radioLine, 0, 1);
        root.add(new Label("Commentaire : "), 0,2);
        root.add(textAreaCommentaire, 0, 3);
        root.add(btnAnnuler, 0, 4);
        root.add(btnValider, 0, 4);
        root.setHalignment(btnAnnuler, HPos.LEFT);
        root.setHalignment(btnValider, HPos.RIGHT);
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Evaluation du repas :");
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