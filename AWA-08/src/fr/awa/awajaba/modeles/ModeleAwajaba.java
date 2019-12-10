/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.modeles;
import fr.awa.awajaba.entites.Repas;
import java.util.List;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    private ModeleAwajaba modele = null;
    private Repas repas;

    public ModeleAwajaba(Repas repas) {
        this.repas = repas;
    }

    public Repas getRepas() {
        return repas;
    }

    public void setRepas(Repas repas) {
        this.repas = repas;
    }

    public ModeleAwajaba getModele() {
        return modele;
    }
    
}
