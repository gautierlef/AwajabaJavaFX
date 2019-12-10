/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.entites;

/**
 *
 * @author developpeur
 */
public class Membre {
    private String identifiant;
    private String nom;
    private String prenom;
    private String adresse;

    public Membre(String identifiant, String nom, String prenom, String adresse) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}