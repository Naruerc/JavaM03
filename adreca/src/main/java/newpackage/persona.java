/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.time.*;
import java.time.temporal.ChronoUnit;
import newpackage.adreca;

/**
 *
 * @author Usuario
 */
public class persona {
    private int idpersona;
    private int dni;
    private String nom;
    private String cognoms;
    private LocalDate naixement;
    private String mail;
    private int tlf;
    private adreca adress;
    private static int numPersones;
    private int edat;
    
    public persona (int idpersona, int dni, String nom, String cognoms){
        this.idpersona=idpersona;
        this.dni=dni;
        this.nom=nom;
        this.cognoms=cognoms;  
        numPersones++;
    }
    
    public persona (int  idpersona, int dni, String nom, String cognoms, LocalDate naixement,
                    int tlf,String mail, adreca adress){
         this.idpersona=idpersona;
         this.dni=dni;
         this.nom=nom;
         this.cognoms=cognoms;
         this.naixement=naixement;
         this.tlf=tlf;
         this.mail=mail;
         this.adress=adress; 
         numPersones++;
    }
    
    public void setIdpersona (int id){
        this.idpersona=id;
    }
    public int getIdpersona(){
        return this.idpersona;
    }
    
    public void setDni (int dni){
        this.dni=dni;
    }
    public int getDni(){
        return this.dni;
    }
    
     public void setNom (String nom){
        this.nom=nom;
    }
    public String getNom(){
        return this.nom;
    }
    
     public void setCognoms (String cognoms){
        this.cognoms=cognoms;
    }
    public String getCognoms(){
        return this.cognoms;
    }
    
     public void setNaixement (LocalDate naixement){
        this.naixement=naixement;
    }
    public LocalDate getNaixement(){
        return this.naixement;
    }
    
       public void setMail (String mail){
        this.mail=mail;
    }
    public String getMail(){
        return this.mail;
    }
    
       public void setTlf (int tlf){
        this.tlf=tlf;
    }
    public int getTlf(){
        return this.tlf;
    }
    
    public void setAdress (adreca adress){
        this.adress=adress;
    }
    public adreca getAdress(){
        return this.adress;
    }
    
       public void setNumPersones (int numPersones){
        this.numPersones=numPersones;
    }
    public static int getNumPersones(){
        return numPersones;
    }
    
    
    public int getEdad(){
        this.edat=(int) ChronoUnit.YEARS.between(naixement,LocalDate.now());
        return edat;
    }
    
    public static long diferenciaEdad (persona p1, persona p2){
        long difEdat=ChronoUnit.YEARS.between(p1.naixement, p2.naixement);
        return difEdat;
    }
    
    public String toString(){
        String retorn=  "Id persona: " +  this.idpersona + "\nDni: " +  this.dni + 
                        "\nNom: " + this.nom + "\nCognoms: " +   this.cognoms +
                        "\nData naixement: " +  this.naixement + "\nMail: " + this.mail +
                        "\nTlf: " +  this.tlf + "\nAdreça: " + this.adress +
                        "\nNumero de persones: " + this.numPersones +
                        "\nEdat: " + this.edat;    
        return retorn;
    }
    
   
}
