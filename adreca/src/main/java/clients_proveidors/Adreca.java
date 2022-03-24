/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients_proveidors;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Adreca implements Serializable{
    
    private static final long SerialVersionUID=3325248135264478306L;

    private String poblacio;
    private String provincia;
    private int CP;
    private String domicili;

    public Adreca(String poblacio, String provincia, int CP, String domicili) {
        this.poblacio = poblacio;
        this.provincia = provincia;
        this.CP = CP;
        this.domicili = domicili;
    }

    ;
    
    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public void setDomicili(String domicili) {
        this.domicili = domicili;
    }

    public String toString() {
        String retorn;

        retorn = "\n   Poblacio: " + this.poblacio + "\n   Provincia: " + this.provincia + "\n   CP: " + this.CP + "\n   Domicili: " + this.domicili;

        return retorn;
    }

}
