/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.modeles;
import fr.awa.awajaba.entites.Membre;
import fr.awa.awajaba.entites.Specialite;
import fr.awa.awajaba.entites.Hote;
import java.util.List;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    private ModeleAwajaba modele = null;
    private Membre membre;
    private Specialite specialite;
    private Hote hote;

    public ModeleAwajaba(Membre membre, Specialite specialite, Hote hote) {
        this.membre = membre;
        this.specialite = specialite;
        this.hote = hote;
    }

    public ModeleAwajaba getModele() {
        return modele;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Hote getHote() {
        return hote;
    }

    public void setHote(Hote hote) {
        this.hote = hote;
    }

}
