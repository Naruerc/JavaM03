/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Usuario
 */
public class adreca {
    
    private String poblacio;
    private String provincia;
    private int CP;
    private String domicili;
    
    public adreca(String poblacio, String provincia, int CP, String domicili){
        this.poblacio=poblacio;
        this.provincia=provincia;
        this.CP=CP;
        this.domicili=domicili;
    };
    
    public void setPoblacio(String poblacio){
        this.poblacio=poblacio;
    }
    
     public void setProvincia(String provincia){
        this.provincia=provincia;
    }
     
      public void setCP(int CP){
        this.CP=CP;
    } 
      
      public void setDomicili(String domicili){
        this.domicili=domicili;
    } 
      
    public String toString(){
        String retorn;
        
        retorn="Poblacio: " +  this.poblacio + "\nProvincia: " +  this.provincia + "\nCP: " + this.CP + "\nDomicili: " +   this.domicili; 
        
        return retorn;
    }
}
