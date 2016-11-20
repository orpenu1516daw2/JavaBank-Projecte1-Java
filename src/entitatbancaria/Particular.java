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

    /**
     * Constructor de Client
     * @param nom par�metre que cont� el nom del client particular
     * @param cognom par�metre que cont� el cognom del client particular
     * @param DNI par�metre que cont� el DNI del client particular
     * @param domicili par�metre que cont� el domicili del client particular
     * @param compte par�metre de tipus ArrayList que cont� tots els comtes
     */
    public Particular(String nom, String cognom, String DNI, String domicili, ArrayList <Compte> compte) {
        super(domicili, compte);
        this.nom = nom;
        this.cognom = cognom;
        this.DNI = DNI;
        
    }

    /**
     * Per obtenir el nom del client particular
     * @return retorna el nom del client particular
     */
    public String getNom() {
        return nom;
    }

    /**
     * Per setejar el nom del client particular
     * @param nom par�metre que cont� el nom del client particular
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Per obtenir el cognom del client particular
     * @return retorna el cognom del client
     */
    public String getCognom() {
        return cognom;
    }

    /**
     * Per setejar el cognom del client particular
     * @param cognom par�metre que cont� el cognom del client
     */
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    /**
     * Per obtenir el DNI del client particular
     * @return retorna el DNI del client
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Per setejar el DNI del client particular
     * @param DNI par�metre que cont� el DNI del client
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    String getCIF() {
        return "";
    }

    /**
     * Per obtenir pr�stecs per l'usuari
     * @return retorna la quantitat que atorga el banc al client.
     */
    @Override
    public double getPrestec() {
        return 60000;
    }
  
}
