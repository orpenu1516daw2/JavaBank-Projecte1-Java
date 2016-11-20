/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitatbancaria;

import java.util.ArrayList;

/**
 *
 * @author oriol
 */
public abstract class Client {
    public String domicili;
    public static int n_comptes;

    ArrayList <Compte> compte;
    
    public Client (String domicili, ArrayList <Compte> compte){
        this.domicili = domicili;
        Client.n_comptes ++;
        this.compte = compte;
    }

    public String getDomicili() {
        return domicili;
    }

    public void setDomicili(String domicili) {
        this.domicili = domicili;
    }

    public int getN_comptes() {
        return n_comptes;
    }

    public void setN_comptes(int n_comptes) {
        this.n_comptes = n_comptes;
    }

    public ArrayList <Compte> getCompte() {
        return compte;
    }

    public void setCompte(ArrayList <Compte> compte) {
        this.compte = compte;
    }

    abstract String getNom();
    abstract String getCognom();
    abstract String getDNI();
    
    abstract String getCIF();

    abstract double getPrestec();
}
