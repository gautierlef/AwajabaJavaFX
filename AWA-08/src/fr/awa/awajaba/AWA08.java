/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import fr.awa.awajaba.entites.Repas;
import fr.awa.awajaba.modeles.ModeleAwajaba;
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
public class AWA08 extends Application {
    
    public TextField textFieldPaf = new TextField("15");
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now().plusDays(1));
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(LocalDate.now().plusDays(1))) {
                            setDisable(true);
                        }
                    }
                };
            }
        };
        datePicker.setDayCellFactory(dayCellFactory);
        String specialite[] = {"Régionale", "Orientale", "Asiatique", "Cannibale", "Africaine", "Française", "Autre"}; 
        ComboBox<String> comboBoxSpecialite = new ComboBox<>(FXCollections.observableArrayList(specialite));
        comboBoxSpecialite.setPromptText("Spécialité");
        comboBoxSpecialite.setVisibleRowCount(3);
        CheckBox checkBoxBio = new CheckBox();
        CheckBox checkBoxVegan = new CheckBox();
        Spinner<Integer> spinnerCouvert = new Spinner<>();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100, 3);
        spinnerCouvert.setValueFactory(valueFactory);
        ToggleGroup groupRB = new ToggleGroup();
        RadioButton rB0 = new RadioButton("Midi\t");
        rB0.setToggleGroup(groupRB);
        rB0.setUserData(false);
        RadioButton rB1 = new RadioButton("Soir\t");
        rB1.setToggleGroup(groupRB);
        rB1.setUserData(true);
        Button btnAnnuler = new Button ("Annuler");
        groupRB.selectToggle(rB0);
        btnAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textFieldPaf.setText("15");
                groupRB.selectToggle(rB0);
                datePicker.setValue(LocalDate.now().plusDays(1));
                checkBoxBio.setSelected(false);
                checkBoxVegan.setSelected(false);
                valueFactory.setValue(3);
                comboBoxSpecialite.setValue("Spécialité");
            }
        });
        Button btnValider = new Button ("Valider");
        btnValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldPaf.getText() == null || "".equals(textFieldPaf.getText()) || textFieldPaf.getText().matches("[0-9]+") == false) {
                    Alert dlgNok = new Alert (Alert.AlertType.ERROR);
                    dlgNok.setTitle ("Erreur");
                    dlgNok.setHeaderText("Erreur de saisie :");
                    dlgNok.setContentText("Veuillez rentrer une paf correcte!");
                    dlgNok.showAndWait();
                } 
                else {
                    if (comboBoxSpecialite.getValue() == null || "Spécialité".equals(comboBoxSpecialite.getValue())) {
                        Alert dlgNok = new Alert (Alert.AlertType.ERROR);
                        dlgNok.setTitle ("Erreur");
                        dlgNok.setHeaderText("Erreur de saisie :");
                        dlgNok.setContentText("Veuillez rentrer une spécialité!");
                        dlgNok.showAndWait();
                    }
                    else {
                        ModeleAwajaba modele = new ModeleAwajaba(new Repas(datePicker.getValue(), Boolean.parseBoolean(groupRB.getSelectedToggle().getUserData().toString()), comboBoxSpecialite.getValue(), Integer.parseInt(valueFactory.getValue().toString()), checkBoxBio.isSelected(), checkBoxVegan.isSelected(), Integer.parseInt(textFieldPaf.getText().trim())));
                        System.out.println("Repas programmé :\nDate : " + modele.getRepas().getDate() + "\nSoir : " + modele.getRepas().isSoir() + "\nSpécialité : " + modele.getRepas().getSpecialite() + "\nNombre de couverts : " + modele.getRepas().getNbCouverts() + "\nBio : " + modele.getRepas().isBio() + "\nVegan : " + modele.getRepas().isVegan() + "\nParticipation au frais : " + modele.getRepas().getPaf());
                        Alert dlgNok = new Alert (Alert.AlertType.INFORMATION);
                        dlgNok.setTitle ("Succès");
                        dlgNok.setHeaderText("Repas programmé avec succès :");
                        dlgNok.setContentText("Repas programmé :\nDate : " + modele.getRepas().getDate() + "\nSoir : " + modele.getRepas().isSoir() + "\nSpécialité : " + modele.getRepas().getSpecialite() + "\nNombre de couverts : " + modele.getRepas().getNbCouverts() + "\nBio : " + modele.getRepas().isBio() + "\nVegan : " + modele.getRepas().isVegan() + "\nParticipation au frais : " + modele.getRepas().getPaf());
                        dlgNok.showAndWait();
                        Platform.exit();
                    }
                }
            }
        });
        Label labelEval = new Label("Programmer votre repas :");
        labelEval.setStyle("-fx-font-weight: bold; -fx-underline: true;");
        root.add(labelEval, 0, 0);
        HBox dateLine = new HBox();
        dateLine.getChildren().add(new Label("Date :\t"));
        dateLine.getChildren().add(datePicker);
        root.add(dateLine, 0, 1);
        HBox radioLine = new HBox();
        radioLine.getChildren().add(new Label("Horaire :\t"));
        radioLine.getChildren().add(rB0);
        radioLine.getChildren().add(rB1);
        root.add(radioLine, 0, 2);
        HBox specialiteLine = new HBox();
        specialiteLine.getChildren().add(new Label("Spécialité :\t"));
        specialiteLine.getChildren().add(comboBoxSpecialite);
        root.add(specialiteLine, 0, 3);
        HBox bioLine = new HBox();
        bioLine.getChildren().add(new Label("Bio :\t"));
        bioLine.getChildren().add(checkBoxBio);
        root.add(bioLine, 0, 4);
        HBox veganLine = new HBox();
        veganLine.getChildren().add(new Label("Vegan :\t"));
        veganLine.getChildren().add(checkBoxVegan);
        root.add(veganLine, 0, 5);
        HBox pafLine = new HBox();
        pafLine.getChildren().add(new Label("Paf :\t"));
        pafLine.getChildren().add(textFieldPaf);
        root.add(pafLine, 0, 6);
        HBox noteLine = new HBox();
        noteLine.getChildren().add(new Label("Nombre couverts :\t"));
        noteLine.getChildren().add(spinnerCouvert);
        root.add(noteLine, 0, 7);
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
