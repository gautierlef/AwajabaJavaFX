/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.modeles;
import fr.awa.awajaba.entites.EvaluationHote;
import java.util.List;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    private ModeleAwajaba modele = null;
    private EvaluationHote evalHote;

    public ModeleAwajaba(EvaluationHote evalConvive) {
        this.evalHote = evalConvive;
    }

    public EvaluationHote getEvalHote() {
        return evalHote;
    }

    public void setEvalHote(EvaluationHote evalHote) {
        this.evalHote = evalHote;
    }

    public ModeleAwajaba getModele() {
        return modele;
    }
    
}
