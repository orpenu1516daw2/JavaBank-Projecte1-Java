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
public class Particular extends Client implements Prestec {
    private String nom;
    private String cognom;
    private String DNI;

    public Particular(String nom, String cognom, String DNI, String domicili, ArrayList <Compte> compte) {
        super(domicili, compte);
        this.nom = nom;
        this.cognom = cognom;
        this.DNI = DNI;
        
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDomicili() {
        return domicili;
    }

    public void setDomicili(String Domicili) {
        this.domicili = Domicili;
    }

    /*@Override
    String getNom_empresa() {
        return "";
    }*/

    @Override
    String getCIF() {
        return "";
    }

    @Override
    public double getPrestec() {
        return 60000;
    }
 
    
}
