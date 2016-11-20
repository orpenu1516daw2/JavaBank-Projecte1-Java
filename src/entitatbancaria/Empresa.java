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

    public Empresa(String nom_empresa, String CIF, String domicili, ArrayList <Compte> compte) {
        super(domicili, compte);
        this.CIF = CIF;
        this.nom_empresa = nom_empresa;
    }

    
    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    /*public String getNom_empresa() {
        return nom_empresa;
    }*/

    public void setNom_empresa(String nom_empresa) {
        this.nom_empresa = nom_empresa;
    }
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
        return CIF;
    }

    @Override
    public double getPrestec() {
        return 160000;
    }


}
