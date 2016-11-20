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

    public T_debit(long n_tarjeta, int pin, double saldo, String n_compte, String dni_cif, double diners) {
        super(n_compte, dni_cif, diners);
        this.n_tarjeta = n_tarjeta;
        this.pin = pin;
        this.saldo = saldo;
    } 
 
    public long getN_tarjeta() {
        return n_tarjeta;
    }

    public void setN_tarjeta(long n_tarjeta) {
        this.n_tarjeta = n_tarjeta;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
 
}
