/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author developpeur
 */
public class AWA09 extends Application {
    
    public TextField textFieldPaf = new TextField("15");
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        String specialite[] = {"Régionale", "Orientale", "Asiatique", "Cannibale", "Africaine", "Française", "Autre"}; 
        Button btnAnnuler = new Button ("Annuler");
        btnAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textFieldPaf.setText("15");
            }
        });
        Button btnValider = new Button ("Valider");
        btnValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                ModeleAwajaba modele = new ModeleAwajaba(new Repas(datePicker.getValue(), Boolean.parseBoolean(groupRB.getSelectedToggle().getUserData().toString()), comboBoxSpecialite.getValue(), Integer.parseInt(valueFactory.getValue().toString()), checkBoxBio.isSelected(), checkBoxVegan.isSelected(), Integer.parseInt(textFieldPaf.getText().trim())));
//                System.out.println("Repas programmé :\nDate : " + modele.getRepas().getDate() + "\nSoir : " + modele.getRepas().isSoir() + "\nSpécialité : " + modele.getRepas().getSpecialite() + "\nNombre de couverts : " + modele.getRepas().getNbCouverts() + "\nBio : " + modele.getRepas().isBio() + "\nVegan : " + modele.getRepas().isVegan() + "\nParticipation au frais : " + modele.getRepas().getPaf());
                Alert dlgNok = new Alert (Alert.AlertType.INFORMATION);
                dlgNok.setTitle ("Succès");
                dlgNok.setHeaderText("Hôte enregistré avec succès :");
                dlgNok.setContentText("...");
                dlgNok.showAndWait();
                Platform.exit();
            }
        });
        Label labelEval = new Label("Enrigistrement d'hôte :");
        labelEval.setStyle("-fx-font-weight: bold; -fx-underline: true;");
        root.add(labelEval, 0, 0);
        HBox identifiantLine = new HBox();
        identifiantLine.getChildren().add(new Label("Identifiant :\t"));
        identifiantLine.getChildren().add();
        root.add(identifiantLine, 0, 1);
        root.add(btnAnnuler, 0, 8);
        root.add(btnValider, 0, 8);
        root.setHalignment(btnAnnuler, HPos.LEFT);
        root.setHalignment(btnValider, HPos.RIGHT);
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);
        Scene scene = new Scene(root, 350, 350);
        primaryStage.setTitle("Progammer repas");
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
