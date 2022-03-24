/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients_proveidors;

import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public interface Persistable<T> {
    
     public void save(T obj);

    public void remove(Integer id);

    public Object search(Integer id);

    public HashMap <Integer, T> getMap();
    
}
