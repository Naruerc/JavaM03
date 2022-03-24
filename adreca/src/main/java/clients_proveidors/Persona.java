/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients_proveidors;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.*;
import clients_proveidors.Adreca;
import java.io.Serializable;
import java.util.LinkedHashSet;

/**
 *
 * @author Usuario
 */
public abstract class Persona implements Identificable, Serializable {
    
    private static final long SerialVersionUID=2325248135264478306L;

    private int idpersona;
    private int dni;
    private String nom;
    private String cognoms;
    private LocalDate naixement;
    private String mail;
    private LinkedHashSet tlf = new LinkedHashSet();
    private Adreca adress;
    private static int numPersones; //variable global 
    private int edat;

    public Persona(int idpersona, int dni, String nom, String cognoms) {
        this.idpersona = idpersona;
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        numPersones++;
    }

    public Persona(int idpersona, int dni, String nom, String cognoms, LocalDate naixement,
            int tlf, String mail, Adreca adress, int edat) {
        this.idpersona = idpersona;
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.naixement = naixement;
        this.tlf.add(tlf);
        this.mail = mail;
        this.adress = adress;
        this.edat = edat;
        numPersones++;
    }

    public Persona() {
    }

    public void setIdpersona(int id) {
        this.idpersona = id;
    }

    public int getId() {
        return this.idpersona;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return this.dni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getCognoms() {
        return this.cognoms;
    }

    public void setNaixement(LocalDate naixement) {
        this.naixement = naixement;
    }

    public LocalDate getNaixement() {
        return this.naixement;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return this.mail;
    }

    public void setTlf(LinkedHashSet tlf) {
        this.tlf = tlf;
    }

    public LinkedHashSet getTlf() {
        return this.tlf;
    }

    public void setAdress(Adreca adress) {
        this.adress = adress;
    }

    public Adreca getAdress() {
        return this.adress;
    }

    /*    public void setNumPersones (int numPersones){
        this.numPersones=numPersones;
    }
     */
    public static int getNumPersones() {
        return numPersones;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getEdat() {       
        return this.edat;
    }

    public static long diferenciaEdad(Persona p1, Persona p2) {
        long difEdat = ChronoUnit.YEARS.between(p1.naixement, p2.naixement);
        return difEdat;
    }

    public String toString() {
        String retorn = "\nId persona: " + this.idpersona + "\nDni: " + this.dni
                + "\nNom: " + this.nom + "\nCognoms: " + this.cognoms
                + "\nData naixement: " + this.naixement + "\nMail: " + this.mail
                + "\nTlf: " + this.tlf + "\nEdat: " + this.edat
                + "\nAdreça: " + this.adress;
        return retorn;
    }

}
