/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.awa.awajaba.modeles;
import fr.awa.awajaba.entites.Hote;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    private ModeleAwajaba modele = null;
    private Hote hote;

    public ModeleAwajaba(Hote hote) {
        this.hote = hote;
    }

    public ModeleAwajaba getModele() {
        return modele;
    }

    public Hote getHote() {
        return hote;
    }

    public void setHote(Hote hote) {
        this.hote = hote;
    }

}
