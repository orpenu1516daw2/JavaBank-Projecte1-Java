/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitatbancaria;

/**
 *
 * @author oriol
 */
public class Compte {
    protected String n_compte;
    protected String dni_cif;
    protected double diners;

    public Compte(String n_compte, String dni_cif, double diners) {
        this.n_compte = n_compte;
        this.dni_cif = dni_cif;
        this.diners = diners;
    }
    
    public String getN_compte() {
        return n_compte;
    }

    public void setN_compte(String n_compte) {
        this.n_compte = n_compte;
    }

    public String getDni_cif() {
        return dni_cif;
    }

    public void setDni_cif(String dni_cif) {
        this.dni_cif = dni_cif;
    }

    public double getDiners() {
        return diners;
    }
    public boolean verificarDiners(double diners){
        if (diners < 0){
            return false;
        }
        return true;
    }
    public void setDiners(double diners) {
        if(verificarDiners(diners)){
            this.diners = diners;  
        }else{
            System.out.println("Quantitat insuficient al compte");
        }
             
    }
    public boolean verificarM(double m){
        if(m <= 0){
            System.out.println("Error: La quantitat " + m + " és incorrecta");
            return false;
        }
        return true;
    }
    
    public double IngressarDiners(double m){
        if(verificarM(m)){
            setDiners(m + diners);   
        }

        return diners;
    }
    public double RetirarDiners(double m){
        if(verificarM(m)){
            setDiners(diners - m);
        }
        
        return diners;
    }
    
}
