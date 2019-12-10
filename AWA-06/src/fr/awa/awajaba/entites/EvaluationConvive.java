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
public class EvaluationConvive {
    private int note = 2;
    private String commentaire;
    private boolean bloque = false;

    public EvaluationConvive(int note, String commentaire, boolean bloque) {
        this.note = note;
        this.commentaire = commentaire;
        this.bloque = bloque;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public boolean isBloque() {
        return bloque;
    }

    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }
}
