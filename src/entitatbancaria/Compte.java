/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitatbancaria;

import java.util.Objects;

/**
 *
 * @author oriol
 */
public class Compte {
    protected String n_compte;
    protected String dni_cif;
    protected double diners;

    /**
     * Constructor de Compte
     * @param n_compte par�metre que cont� el n�mero de compte del client
     * @param dni_cif par�metre que cont� el DNI o el CIF associat al compte del client
     * @param diners par�metre que cont� els diners del compte del client
     */
    public Compte(String n_compte, String dni_cif, double diners) {
        this.n_compte = n_compte;
        this.dni_cif = dni_cif;
        this.diners = diners;
    }
    
    /**
     * Per obtenir el n�mero de compte del client
     * @return retorna el n�mero de compte del client
     */
    public String getN_compte() {
        return n_compte;
    }

    /**
     * Per setejar el n�mero de compte del client
     * @param n_compte par�metre que cont� el n�mero de compte del client
     */
    public void setN_compte(String n_compte) {
        this.n_compte = n_compte;
    }

    /**
     * Per obtenir el DNI o el CIF associat al compte del client
     * @return retorna el DNI o el CIF associat al compte del client
     */
    public String getDni_cif() {
        return dni_cif;
    }

    /**
     * Per setejar el DNI o el CIF associat al compte del client
     * @param dni_cif par�metre que cont� el DNI o CIF associat al compte del client
     */
    public void setDni_cif(String dni_cif) {
        this.dni_cif = dni_cif;
    }

    /**
     * Per obtenir els diners del compte del client
     * @return retorna els diners del compte
     */ 
    public double getDiners() {
        return diners;
    }

    /**
     * Serveix per verificar que els diners del compte s�n superiors a 0 (�s a dir, que hi ha diners)
     * @param diners par�metre que cont� els diners del compte
     * @return retorna true o false en funci� de si la quantitat de diners est� per sobre de 0.
     * En cas de que la quantitat a extreure sigui major que la actual avisa de que no es disposa de tal quantitat
     */
    public boolean verificarDiners(double diners){
        if (diners < 0){
            System.out.println("Quantitat insuficient al compte");
            return false;
        }
        return true;
    }

    /**
     * Per setejar els diners del compte, si verificarDiners ho permet
     * @param diners par�metre que cont� els diners del compte
     */
    public void setDiners(double diners) {
        if(verificarDiners(diners)){
            this.diners = diners;  
        }             
    }

    /**
     * Serveix per verificar que la quantitat que intentem ingressar o retirar �s v�lida
     * @param m par�metre que cont� els diners que l'usuari vol ingressar o retirar del compte
     * @return retorna true o false en funci� de si la quantitat �s v�lida o no, i en cas de que no ho sigui avisa de que aquesta xifra no serveix
     */
    public boolean verificarM(double m){
        if(m <= 0){
            System.out.println("Error: La quantitat " + m + " �s incorrecta");
            return false;
        }
        return true;
    }
    
    /**
     * Serveix per ingressar diners al compte del client si verificarM ho permet
     * @param m par�metre que cont� els diners que l'usuari vol ingressar
     * @return retorna la quantitat de diners del compte
     */
    public double IngressarDiners(double m){
        if(verificarM(m)){
            setDiners(m + diners);   
        }

        return diners;
    }

    /**
     * Serveix per retirar diners del compte del client si verificarM ho permet
     * @param m par�metre que cont� els diners que l'usuari vol retirar
     * @return retorna la quantitat de diners del compte
     */
    public double RetirarDiners(double m){
        if(verificarM(m)){
            setDiners(diners - m);
        }
        
        return diners;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.n_compte);
        hash = 37 * hash + Objects.hashCode(this.dni_cif);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.diners) ^ (Double.doubleToLongBits(this.diners) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compte other = (Compte) obj;
        if (!Objects.equals(this.n_compte, other.n_compte)) {
            return false;
        }
        if (!Objects.equals(this.dni_cif, other.dni_cif)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compte{" + "n_compte=" + n_compte + ", dni_cif=" + dni_cif + ", diners=" + diners + '}';
    }
    
    
    
}
