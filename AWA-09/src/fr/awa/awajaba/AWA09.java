/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import fr.awa.awajaba.entites.Hote;
import fr.awa.awajaba.entites.Membre;
import fr.awa.awajaba.entites.Specialite;
import fr.awa.awajaba.modeles.ModeleAwajaba;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author developpeur
 */
public class AWA09 extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Membre membre = new Membre("Le Gourmet", "Yukihira", "Soma", "shokugeki@nosoma.com");
        Specialite lesSpecialites[] = {new Specialite("Régionale"), new Specialite("Orientale"), new Specialite("Asiatique"), new Specialite("Cannibale"), new Specialite("Africaine"), new Specialite("Française"), new Specialite("Autre")}; 
        ListView listViewSpecialite = new ListView();
        listViewSpecialite.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listViewSpecialite.getItems().addAll(lesSpecialites);
        Button btnAnnuler = new Button ("Annuler");
        btnAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listViewSpecialite.getSelectionModel().clearSelection();
            }
        });
        Button btnValider = new Button ("Valider");
        btnValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (listViewSpecialite.getSelectionModel().getSelectedItems().isEmpty()) {
                    Alert dlgNok = new Alert (Alert.AlertType.ERROR);
                    dlgNok.setTitle ("Erreur");
                    dlgNok.setHeaderText("Erreur de saisie :");
                    dlgNok.setContentText("Veuillez choisir au moins une spécialité!");
                    dlgNok.showAndWait();
                }
                else {
                    ModeleAwajaba modele = new ModeleAwajaba(new Hote(membre, listViewSpecialite.getSelectionModel().getSelectedItems()));
                    System.out.println("Hôte enregistré :\nIdentifiant : " + modele.getHote().getMembre().getIdentifiant() + "\nNom : " + modele.getHote().getMembre().getNom() + "\nPrénom : " + modele.getHote().getMembre().getPrenom() + "\nAdresse : " + modele.getHote().getMembre().getAdresse() + "\nSpécialités : " + modele.getHote().getSpecialite());
                    Alert dlgNok = new Alert (Alert.AlertType.INFORMATION);
                    dlgNok.setTitle ("Succès");
                    dlgNok.setHeaderText("Hôte enregistré avec succès :");
                    dlgNok.setContentText("Hôte enregistré :\nIdentifiant : " + modele.getHote().getMembre().getIdentifiant() + "\nNom : " + modele.getHote().getMembre().getNom() + "\nPrénom : " + modele.getHote().getMembre().getPrenom() + "\nAdresse : " + modele.getHote().getMembre().getAdresse() + "\nSpécialités : " + modele.getHote().getSpecialite());
                    dlgNok.showAndWait();
                    Platform.exit();
                }
            }
        });
        Label labelEval = new Label("Enregistrement d'hôte :");
        labelEval.setStyle("-fx-font-weight: bold; -fx-underline: true;");
        root.add(labelEval, 0, 0);
        root.add(new Label("Identifiant : " + membre.getIdentifiant()), 0, 1);
        root.add(new Label("Nom : " + membre.getNom()), 0, 2);
        root.add(new Label("Prénom : " + membre.getPrenom()), 0, 3);
        root.add(new Label("Adresse : " + membre.getAdresse()), 0, 4);
        root.add(new Label("Spécialité :"), 0, 5);
        root.add(listViewSpecialite, 0, 6);
        root.add(btnAnnuler, 0, 7);
        root.add(btnValider, 0, 7);
        root.setHalignment(btnAnnuler, HPos.LEFT);
        root.setHalignment(btnValider, HPos.RIGHT);
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);
        Scene scene = new Scene(root, 300, 350);
        primaryStage.setTitle("Enregistrer hôte");
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
