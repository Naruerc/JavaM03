package clients_proveidors;


import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class ComparadorStock implements Comparator<Productes>  {
    
    @Override
    public int compare(Productes o1, Productes o2) {
        return  o1.getStock()-o2.getStock();
    }
    
}
