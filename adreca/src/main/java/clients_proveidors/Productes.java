/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients_proveidors;

import java.util.HashMap;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author Usuario
 */
public class Productes implements Identificable, Serializable{
    
    private static final long SerialVersionUID=1325248135264478306L;

    private int idproducte;
    private String nom;
    private int preuVenda;
    private int stock;
    
    //caldria comprobar que no es pogui introduir una data inici mes recent a una final
    //toda la implementacion no la he heco para packs
    private LocalDate DataIniciCataleg;
    private LocalDate DataFinalCataleg;
    
    
    public static Logger logger = Logger.getLogger("Example");

    public boolean equals(Productes obj, HashMap<Integer, Productes> map) {

        int i = 0;

        for (Integer clave : map.keySet()) {

            //aqui SEMPRE es trobara a si mateix, pel que faig un comptador que ha de ser minim de 2 per que sigui trobat
            //ja que com a minim i serà 1 pq es troba a si mateix
            if (obj.getNom().equals(map.get(clave).getNom())) {
                i++;
            }
        }

        if (i > 1) {
            return true;
        } else {
            return false;
        }
    }

    //constructors
    public Productes(int idproducte, String nom, int preuVenda, int stock, LocalDate dataInici, LocalDate dataFinal) {
        this.idproducte = idproducte;
        this.nom = nom;
        this.preuVenda = preuVenda;
        this.stock = stock;        
        this.DataIniciCataleg= dataInici;
        this.DataFinalCataleg= dataFinal;
        
    
    }
    

    public Productes() {
    }

    //setters
    public void setIdproducte(int idproducte) {
        this.idproducte = idproducte;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPreuVenda(int preuVenda) {
        this.preuVenda = preuVenda;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //getters
    @Override
    public int getId() {
        return this.idproducte;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPreuVenda() {
        return this.preuVenda;
    }

    public int getStock() {
        return this.stock;
    }
    
    public LocalDate getDataIniciCataleg() {
        return DataIniciCataleg;
    }

    public void setDataIniciCataleg(LocalDate DataIniciCataleg) {
        this.DataIniciCataleg = DataIniciCataleg;
    }

    public LocalDate getDataFinalCataleg() {
        return DataFinalCataleg;
    }

    public void setDataFinalCataleg(LocalDate DataFinalCataleg) {
        this.DataFinalCataleg = DataFinalCataleg;
    }

    public String toString() {
        return "\nId producte: " + this.idproducte + "\nNom: " + this.nom + "\nPreu Venda: "
                + this.preuVenda + "\nStock: " + this.stock + "\nData Inici Cataleg: " + this.getDataIniciCataleg()
                + "\nData Final Cataleg: " + this.getDataFinalCataleg();
    }
    
    public void putStock(int quant){
        stock=stock+quant;
    }
    
    public void takeStock(int quant) throws StockInsuficientException {
        if (quant > stock) {
            
            //si se da el caso de quant > stock crea un error nuevo de tipo  StockInsuficientException (como si fuera una variable)
            //la varaible en si no hace nada, por lo que hay que hacer un throw de la variable, como si fuera un "return"
            StockInsuficientException errorStock = new StockInsuficientException("No es pot retirar, no hi ha tant stock disponible");
            throw errorStock;
        } else {
            stock = stock - quant;
            System.out.println("Stock retirat amb exit");
        }

    }


}
