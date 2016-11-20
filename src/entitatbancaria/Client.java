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
    
    /**
     * Constructor de Client
     * @param domicili par�metre que cont� el domicili del client
     * @param compte par�metre de tipus ArrayList que cont� tots els comtes
     */
    public Client (String domicili, ArrayList <Compte> compte){
        this.domicili = domicili;
        Client.n_comptes ++;
        this.compte = compte;
    }

    /**
     * Per obtenir el domicili del client
     * @return retorna el domicili del client
     */
    public String getDomicili() {
        return domicili;
    }

    /**
     * Per setejar el domicili del client
     * @param domicili par�metre que cont� el domicili del client
     */
    public void setDomicili(String domicili) {
        this.domicili = domicili;
    }

    /**
     * Per obtenir el n�mero de comptes del client
     * @return retorna el n�mero de comptes del client
     */
    public int getN_comptes() {
        return n_comptes;
    }

    /**
     * Per setejar el n�mero de comptes del client
     * @param n_comptes par�metre que cont� el n�mero de comptes del client
     */
    public void setN_comptes(int n_comptes) {
        Client.n_comptes = n_comptes;
    }

    /**
     * ArrayList que cont� tots els comptes
     * @return retorna el comtpte del client
     */
    public ArrayList <Compte> getCompte() {
        return compte;
    }

    /**
     * Per setejar el compte del client
     * @param compte par�metre que cont� el compte del client
     */
    public void setCompte(ArrayList <Compte> compte) {
        this.compte = compte;
    }

    abstract String getNom();
    abstract String getCognom();
    abstract String getDNI();
    
    abstract String getCIF();

    abstract double getPrestec();
}
