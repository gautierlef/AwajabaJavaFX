/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.modeles;
import fr.awa.awajaba.entites.EvaluationConvive;
import java.util.List;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    private ModeleAwajaba modele = null;
    private EvaluationConvive evalConvive;

    public ModeleAwajaba(EvaluationConvive evalConvive) {
        this.evalConvive = evalConvive;
    }

    public EvaluationConvive getEvalConvive() {
        return evalConvive;
    }

    public void setEvalConvive(EvaluationConvive evalConvive) {
        this.evalConvive = evalConvive;
    }

    public ModeleAwajaba getModele() {
        return modele;
    }
    
}
