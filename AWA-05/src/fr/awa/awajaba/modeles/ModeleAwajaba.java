/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.modeles;
import fr.awa.awajaba.entites.EvaluationRepas;
import java.util.List;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    private ModeleAwajaba modele = null;
    private EvaluationRepas evalRepas;

    public ModeleAwajaba(EvaluationRepas evalRepas) {
        this.evalRepas = evalRepas;
    }

    public EvaluationRepas getEvalRepas() {
        return evalRepas;
    }

    public void setEvalRepas(EvaluationRepas evalRepas) {
        this.evalRepas = evalRepas;
    }

    public ModeleAwajaba getModele() {
        return modele;
    }
    
}
