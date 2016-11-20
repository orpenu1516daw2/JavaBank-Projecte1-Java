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
public interface Prestec {
    
    /**
     * Interfície per obtenir prestecs per els clients
     * @return retornarà la quantitat que atorga el banc al client que sol·licita un prèstec
     */
    public double getPrestec();
        
}
