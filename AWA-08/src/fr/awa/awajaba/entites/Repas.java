/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.entites;

import java.time.LocalDate;

/**
 *
 * @author developpeur
 */
public class Repas {
    private LocalDate date;
    private boolean soir = true;
    private String specialite;
    private int nbCouverts = 3;
    private boolean bio = false;
    private boolean vegan = false; 
    private int paf = 15;

    public Repas(LocalDate date, boolean soir, String specialite, int nbCouverts, boolean bio, boolean vegan, int paf) {
        this.date = date;
        this.soir = soir;
        this.specialite = specialite;
        this.nbCouverts = nbCouverts;
        this.bio = bio;
        this.vegan = vegan;
        this.paf = paf;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isSoir() {
        return soir;
    }

    public void setSoir(boolean soir) {
        this.soir = soir;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getNbCouverts() {
        return nbCouverts;
    }

    public void setNbCouverts(int nbCouverts) {
        this.nbCouverts = nbCouverts;
    }

    public boolean isBio() {
        return bio;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public int getPaf() {
        return paf;
    }

    public void setPaf(int paf) {
        this.paf = paf;
    }
}