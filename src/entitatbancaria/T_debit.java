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
     * Constructor de Targetes de dèbit
     * @param n_tarjeta paràmetre que contè el número de targeta
     * @param pin paràmetre que contè el pin de seguretat generat per l'usuari
     * @param saldo paràmetre que contè el saldo de la targeta
     * @param n_compte paràmetre que contè el número de compte associat a la targeta de crèdit
     * @param dni_cif paràmetre que contè el DNI o CIF del client associat a la targeta de crèdit
     * @param diners paràmetre que contè els diners de la targeta
     */
    public T_debit(long n_tarjeta, int pin, double saldo, String n_compte, String dni_cif, double diners) {
        super(n_compte, dni_cif, diners);
        this.n_tarjeta = n_tarjeta;
        this.pin = pin;
        this.saldo = saldo;
    } 
 
   /**
     * Per obtenir el número de targeta
     * @return retorna el número de targeta
     */
    public long getN_tarjeta() {
        return n_tarjeta;
    }

    /**
     * Per setejar el número de targeta
     * @param n_tarjeta paràmetre que contè el número de targeta
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
     * @param pin paràmetre que contè el pin de seguretat
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * Per obtenir el saldo de la targeta
     * @return retorna el saldo de la targeta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Per setejar el saldo de la targeta
     * @param saldo paràmetre que contè el saldo de la targeta
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.n_tarjeta ^ (this.n_tarjeta >>> 32));
        hash = 17 * hash + this.pin;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
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
        final T_debit other = (T_debit) obj;
        if (this.n_tarjeta != other.n_tarjeta) {
            return false;
        }
        if (this.pin != other.pin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "T_debit{" + "n_tarjeta=" + n_tarjeta + ", pin=" + pin + ", saldo=" + saldo + '}';
    }
 
}
