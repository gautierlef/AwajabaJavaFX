/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import fr.awa.awajaba.entites.EvaluationConvive;
import fr.awa.awajaba.modeles.ModeleAwajaba;
import javafx.application.Application;
import javafx.application.Platform;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.CheckBox;
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
public class AWA06 extends Application {
    
    public TextArea textAreaCommentaire = new TextArea();
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Spinner<Integer> spinnerNote = new Spinner<>();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 2);
        spinnerNote.setValueFactory(valueFactory);
        CheckBox checkBoxBloque = new CheckBox();
        Button btnAnnuler = new Button ("Annuler");
        btnAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                valueFactory.setValue(2);
                spinnerNote.setValueFactory(valueFactory);
                textAreaCommentaire.setText("");
                checkBoxBloque.setSelected(false);
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
                    ModeleAwajaba modele = new ModeleAwajaba(new EvaluationConvive(spinnerNote.getValue(), textAreaCommentaire.getText(), checkBoxBloque.isSelected()));
                    System.out.println("Evaluation ajoutée :\nNote : " + modele.getEvalConvive().getNote() + "\nCommentaire : " + modele.getEvalConvive().getCommentaire() + "\nBloqué : " + modele.getEvalConvive().isBloque());
                    Alert dlgNok = new Alert (AlertType.INFORMATION);
                    dlgNok.setTitle ("Succès");
                    dlgNok.setHeaderText("Evaluation ajoutée avec succès :");
                    dlgNok.setContentText("Note : " + modele.getEvalConvive().getNote() + "\nCommentaire : " + modele.getEvalConvive().getCommentaire() + "\nBloqué : " + modele.getEvalConvive().isBloque());
                    dlgNok.showAndWait();
                    Platform.exit();
                }
            }
        });
        Label labelEval = new Label("Evaluer votre convive :");
        labelEval.setStyle("-fx-font-weight: bold; -fx-underline: true;");
        root.add(labelEval, 0, 0);
        HBox noteLine = new HBox();
        noteLine.getChildren().add(new Label("Note :\t"));
        noteLine.getChildren().add(spinnerNote);
        root.add(noteLine, 0, 1);
        root.add(new Label("Commentaire : "), 0, 2);
        root.add(textAreaCommentaire, 0, 3);
        HBox bloqueLine = new HBox();
        bloqueLine.getChildren().add(new Label("Bloquer convive :\t"));
        bloqueLine.getChildren().add(checkBoxBloque);
        root.add(bloqueLine, 0, 4);
        root.add(btnAnnuler, 0, 5);
        root.add(btnValider, 0, 5);
        root.setHalignment(btnAnnuler, HPos.LEFT);
        root.setHalignment(btnValider, HPos.RIGHT);
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Evaluation du convive");
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