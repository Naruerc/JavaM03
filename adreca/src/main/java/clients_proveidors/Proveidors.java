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

/**
 *
 * @author Usuario
 */
public class Proveidors extends Persona  {

    public Proveidors(int idpersona, int dni, String nom, String cognoms) {
        super(idpersona, dni, nom, cognoms);
    }

    public Proveidors(int idpersona, int dni, String nom, String cognoms, LocalDate naixement, int tlf,
            String mail, Adreca adress, int edat) {
        super(idpersona, dni, nom, cognoms, naixement, tlf, mail, adress, edat);
    }

    public Proveidors() {
        super();
    }
}
