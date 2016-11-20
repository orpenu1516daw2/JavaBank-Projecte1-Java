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
public class T_credit extends Compte {
    private long n_tarjeta;
    private int pin;

    /**
     * Constructor de Targetes de cr�dit
     * @param n_tarjeta par�metre que cont� el n�mero de targeta 
     * @param pin par�metre que cont� el pin de seguretat que ha escollit l'usuari
     * @param n_compte par�metre que cont� el n�mero de compte associat a la targeta de cr�dit
     * @param dni_cif par�metre que cont� el DNI o CIF del client associat a la targeta de cr�dit
     * @param diners par�metre que cont� els diners de la targeta
     */
    public T_credit(long n_tarjeta, int pin, String n_compte, String dni_cif, double diners) {
        super(n_compte, dni_cif, diners);
        this.n_tarjeta = n_tarjeta;
        this.pin = pin;
    }
        
    /**
     * Per obtenir el n�mero de targeta
     * @return retorna el n�mero de targeta
     */
    public long getN_tarjeta() {
        return n_tarjeta;
    }

    /**
     * Per setejar el n�mero de targeta
     * @param n_tarjeta par�metre que cont� el n�mero de targeta
     */
    public void setN_tarjeta(long n_tarjeta) {
        this.n_tarjeta = n_tarjeta;
    }

    /**
     * Per obtenir el pin de seguretat que crea l'usuari
     * @return retorna el pin de seguretat
     */
    public int getPin() {
        return pin;
    }

    /**
     * Per setejar el pin de seguretat
     * @param pin par�metre que cont� el pin de seguretat
     */
    public void setPin(int pin) {
        this.pin = pin;
    }
  
}
