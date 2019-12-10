/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.awa.awajaba.entites;

import java.util.List;

/**
 *
 * @author developpeur
 */
public class Hote {
    private Membre membre;
    private List<Specialite> specialite;

    public Hote(Membre membre, List<Specialite> specialite) {
        this.membre = membre;
        this.specialite = specialite;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public List<Specialite> getSpecialite() {
        return specialite;
    }

    public void setSpecialite(List<Specialite> specialite) {
        this.specialite = specialite;
    }
}