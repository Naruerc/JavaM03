/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients_proveidors;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import java.util.HashMap;

/**
 *
 * @author Usuario
 */

//se podria conseguir el mismo resultaod final si identificable no existiera?
//no hay que implementar la de modificar?

public class DAO<T extends Identificable> implements Persistable<T>, Serializable{

    private HashMap<Integer, T> hashMap = new HashMap<Integer, T>();
    //private HashMap<Integer, T> tlfs = new HashMap<Integer, T>();//para hacer lista de tlf habria que hacerlo aqui y no en Persona vd?

   
    
    public DAO(){};
    
    @Override
    public void save(T obj){
        hashMap.put(obj.getId(), obj);
    }

    @Override
    public void remove(Integer id){        
         hashMap.remove(id);         
    }
    
    
    public void modify(T obj){      //NO FARÉ QUE ES POGUI EDITAR LA DATA INICI/FINAL CATALEG DELS PRODUCTES  
          if (obj instanceof Productes) {
            ((Productes) hashMap.get(((Productes) obj).getId())).setNom(((Productes) obj).getNom());
            ((Productes) hashMap.get(((Productes) obj).getId())).setPreuVenda(((Productes) obj).getPreuVenda());
            ((Productes) hashMap.get(((Productes) obj).getId())).setStock(((Productes) obj).getStock());
            ((Productes) hashMap.get(((Productes) obj).getId())).setDataIniciCataleg(((Productes) obj).getDataFinalCataleg());
            ((Productes) hashMap.get(((Productes) obj).getId())).setDataFinalCataleg(((Productes) obj).getDataFinalCataleg());
        } else if (obj instanceof Packs) {
            ((Packs) hashMap.get(((Packs) obj).getId())).setNom(((Packs) obj).getNom());
            ((Packs) hashMap.get(((Packs) obj).getId())).setPreuVenda(((Packs) obj).getPreuVenda());
            ((Packs) hashMap.get(((Packs) obj).getId())).setStock(((Packs) obj).getStock());
            ((Packs) hashMap.get(((Packs) obj).getId())).setPercentatgeDescompte(((Packs) obj).getPercentatgeDescompte());
            

        } else if (obj instanceof Clients) {
            ((Clients) hashMap.get(((Clients) obj).getId())).setDni(((Clients) obj).getDni());
            ((Clients) hashMap.get(((Clients) obj).getId())).setNom(((Clients) obj).getNom());
            ((Clients) hashMap.get(((Clients) obj).getId())).setCognoms(((Clients) obj).getCognoms());
            ((Clients) hashMap.get(((Clients) obj).getId())).setNaixement(((Clients) obj).getNaixement());
            ((Clients) hashMap.get(((Clients) obj).getId())).setTlf(((Clients) obj).getTlf());
            ((Clients) hashMap.get(((Clients) obj).getId())).setMail(((Clients) obj).getMail());
            ((Clients) hashMap.get(((Clients) obj).getId())).setAdress(((Clients) obj).getAdress());
            ((Clients) hashMap.get(((Clients) obj).getId())).setEdat(((Clients) obj).getEdat());           
        } else if (obj instanceof Proveidors) {
            ((Proveidors) hashMap.get(((Proveidors) obj).getId())).setDni(((Proveidors) obj).getDni());
            ((Proveidors) hashMap.get(((Proveidors) obj).getId())).setNom(((Proveidors) obj).getNom());
            ((Proveidors) hashMap.get(((Proveidors) obj).getId())).setCognoms(((Proveidors) obj).getCognoms());
            ((Proveidors) hashMap.get(((Proveidors) obj).getId())).setNaixement(((Proveidors) obj).getNaixement());
            ((Proveidors) hashMap.get(((Proveidors) obj).getId())).setTlf(((Proveidors) obj).getTlf());
            ((Proveidors) hashMap.get(((Proveidors) obj).getId())).setMail(((Proveidors) obj).getMail());
            ((Proveidors) hashMap.get(((Proveidors) obj).getId())).setAdress(((Proveidors) obj).getAdress());
            ((Proveidors) hashMap.get(((Proveidors) obj).getId())).setEdat(((Proveidors) obj).getEdat());           
        }             
    }
    
     public void putStockDao(int quant, Integer id){ 
          ((Productes)hashMap.get(id)).putStock(quant);         
     }
     
      public void takeStockDao(int quant, Integer id){ 
          try{
          ((Productes)hashMap.get(id)).takeStock(quant);
          }
          catch(StockInsuficientException st){
               System.out.println(st.getMessage());
          }
         //gracias al throw de takeStock podemos recoger la variable del error con el catch, si ejecutaramos el codigo del "try"
         //pero quitando el try daria error, i deberiamos añadir "throws StockInsuficientException" en la capçalera de la funcion
         //ya que esta intentando ejecutar una funcion (takeStock) la qual puede darse un error, luego en el main de IniciVista
         //tmb deberia añadir "throws StockInsuficientException" ya que esta llamando a "takeStockDao" el qual tmb puede dar un error
         //de tipo StockInsuficientException. Por lo que mejor usar try catch
     }

    @Override
    public T search(Integer id){
         boolean trobat = false;

        for (Integer clave : hashMap.keySet()) {

            if (id == hashMap.get(clave).getId()) {
                trobat = true;
            }
        }

        if (trobat) {
            return hashMap.get(id);
        } else {
            return null;
        }
    }

    @Override
    public HashMap <Integer, T> getMap(){
        return hashMap;
    }
    
     public void setMap(HashMap<Integer, T> hashMap) {
        this.hashMap = hashMap;
    }
    
     //al srotir de l'app s'executa aquesta funcio i guarda tots els productes a productes.dat
    public void guardarFitxer() throws IOException{
      try{         
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productes.dat"));
        oos.writeObject(hashMap); //com ho crida daoProd, el hashmap d'aquest son productes i pakcs, son el que es guardara
        oos.close();
          System.out.println("Dades guardades amb èxit");
      }      
      catch(IOException io){
          System.out.println("Fitxer no es pot guardar");
      }
       
    }
    
      //al entrar a l'app s'executa aquesta funcio i crea tots els productes a partir del productes.dat
    public void obrirFitxer()  throws IOException, FileNotFoundException, ClassNotFoundException, InvalidClassException{
      try{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productes.dat"));
        this.hashMap = (HashMap<Integer, T>)ois.readObject();   
        ois.close();
        System.out.println("Dades carregades amb èxit");
      }
      catch(FileNotFoundException fi){
          System.out.println("Fitxer no trobat");
      }
   
    }
    
    //no ho implementaré per a packs    
    public void mostrarDescatalogados(LocalDate data){//implementar funcionalidad diferencia de dias: fa x dias que esta descatalogat
        
         //Period p = Period.between( data, data);      
         
         long daysDifference=2;
         
        System.out.println("Llista dels productes descatalogats a partir del dia: "+data.toString());        
        
         for (Integer clave : hashMap.keySet()) {

          if(((Productes)(hashMap.get(clave))).getDataFinalCataleg().compareTo(data)<0)
              
               daysDifference = ChronoUnit.DAYS.between(((Productes)(hashMap.get(clave))).getDataFinalCataleg(), data);
                // p = Period.between( ((Productes)(hashMap.get(clave))).getDataFinalCataleg(), data);                 
                 System.out.println(hashMap.get(clave).toString());
                 System.out.println("Dies descatalogat: "+daysDifference);
                
        }
         
    }
            
            
}
