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
public class Empresa extends Client implements Prestec {
    private String CIF;
    public String nom_empresa;

    /**
     * Constructor d'Empresa
     * @param nom_empresa paràmetre que contè el nom de la empresa
     * @param CIF paràmetre que contè el CIF de la empresa
     * @param domicili paràmetre que contè el domicili de la empresa
     * @param compte paràmetre de tipus ArrayList que contè tots els comtes
     */
    public Empresa(String nom_empresa, String CIF, String domicili, ArrayList <Compte> compte) {
        super(domicili, compte);
        this.CIF = CIF;
        this.nom_empresa = nom_empresa;
    }

    /**
     * Per obtenir el CIF del client empresa
     * @return retorna el CIF de l'empresa
     */
    public String getCIF() {
        return CIF;
    }

    /**
     * Per setejar el CIF del client empresa
     * @param CIF paràmetre que contè el CIF de la empresa
     */
    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    /**
     * Per setejar el nom del client empresa
     * @param nom_empresa paràmetre que contè el nom de la empresa
     */
    public void setNom(String nom_empresa) {
        this.nom_empresa = nom_empresa;
    }

    @Override
    String getCognom() {
        return "";
    }

    @Override
    String getNom() {
        return nom_empresa;
    }

    @Override
    String getDNI() {
        return "";
    }

    /**
     * Per obtenir prèstecs per l'usuari
     * @return retorna la quantitat que atorga el banc al client.
     */
    @Override
    public double getPrestec() {
        return 160000;
    }

}
