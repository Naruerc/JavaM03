/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients_proveidors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Packs extends Productes {

    //llista de productes que conté un producte
    private HashMap<Integer, Productes> Packs = new HashMap<Integer, Productes>();

    private float percentatgeDescompte;

    //com que no guardem l'stock? 1r que si que es util per saber quants packs de X tenim
    //despres que latribut stock s'hereda de la clase producte no?
    public Packs() {
    }

    //constructor que reutilitza el constructor de la classe mare
    public Packs(int idproducte, String nom, int preuVenda, int stock, float percentatgeDescompte) {
        super(idproducte, nom, preuVenda, stock, LocalDate.now(), LocalDate.now());
        this.percentatgeDescompte = percentatgeDescompte;
        this.Packs=new HashMap<Integer, Productes>();
    }

    //setters i getters
    public HashMap<Integer, Productes> getPacks() {
        return this.Packs;
    }
   
    public void setPercentatgeDescompte(float percentatgeDescompte) {
        this.percentatgeDescompte = percentatgeDescompte;
    }

    public float getPercentatgeDescompte() {
        return this.percentatgeDescompte;
    }

    //metodes             
    public void afegirProducte(Productes prod) { //no hauria de permetre introduir un id repetit no? Si ja conte aquest id. Implementarho      
       Packs.put(prod.getId(), prod);
    }

    public void retirarProducte(Productes prod) {
        Packs.remove(prod.getId());        
    }

    @Override
    public String toString() {

        String retorn = "\nID pack: " + this.getId() +
                        "\nNom: " + this.getNom() +
                        "\nPreu Venda: " + this.getPreuVenda() +
                        "\nPercentatge descompte: " + this.getPercentatgeDescompte() +
                        "\nStock: " + this.getStock() +
                        "\nProductes que inclou:";

        
         for (Integer clave : this.Packs.keySet()) {

            retorn = retorn + clave + ", ";
        }
        
        return retorn;
    }

    public boolean equals(Packs paquete) {

        boolean trobat = false;
        int x = 0;

        if (paquete.Packs.size() != this.Packs.size()) {
            return false;
        } else {

            for (int i = 0; i < this.Packs.size(); i++) {
                trobat = false;

                for (int j = 0; j < paquete.Packs.size(); j++) {
                    if (this.Packs.get(i) == paquete.Packs.get(j)) {
                        trobat = true;
                        x++;
                    }
                }
            }
            if (x == this.Packs.size()) {
                return true;
            } else {
                return false;
            }
        }
    }

}
