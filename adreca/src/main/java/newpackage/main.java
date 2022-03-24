/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Usuario
 */
public class main {
     public static void main(String[] args){
         adreca adress = new adreca("Sant Cugat del Vallès", "Barcelona", 8173, "Carretera Vallvidrera");
         
         
         String poblaci="Hola naruto";
         adress.setDomicili(poblaci);
      
        
         String resultat=adress.toString();
         System.out.println(resultat);
         
         LocalDate naixement=LocalDate.now();;
         System.out.println(naixement);
         
         LocalTime ahora = LocalTime.now();
         System.out.println(ahora);
     }
    
}
