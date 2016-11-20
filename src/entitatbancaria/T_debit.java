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
public class T_debit extends Compte {
    private long n_tarjeta;
    private int pin;
    private double saldo;

    /**
     * Constructor de Tarjetes de d�bit
     * @param n_tarjeta par�metre que cont� el n�mero de tarjeta
     * @param pin par�metre que cont� el pin de seguretat generat per l'usuari
     * @param saldo par�metre que cont� el saldo de la tarjeta
     * @param n_compte par�metre que cont� el n�mero de compte associat a la tarjeta de cr�dit
     * @param dni_cif par�metre que cont� el DNI o CIF del client associat a la tarjeta de cr�dit
     * @param diners par�metre que cont� els diners de la tarjeta
     */
    public T_debit(long n_tarjeta, int pin, double saldo, String n_compte, String dni_cif, double diners) {
        super(n_compte, dni_cif, diners);
        this.n_tarjeta = n_tarjeta;
        this.pin = pin;
        this.saldo = saldo;
    } 
 
   /**
     * Per obtenir el n�mero de tarjeta
     * @return retorna el n�mero de tarjeta
     */
    public long getN_tarjeta() {
        return n_tarjeta;
    }

    /**
     * Per setejar el n�mero de tarjeta
     * @param n_tarjeta par�metre que cont� el n�mero de tarjeta
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

    /**
     * Per obtenir el saldo de la tarjeta
     * @return retorna el saldo de la tarjeta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Per setejar el saldo de la tarjeta
     * @param saldo par�metre que cont� el saldo de la tarjeta
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
 
}
