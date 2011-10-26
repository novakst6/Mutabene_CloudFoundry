/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.interfaces;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author stenlik
 */
public interface IDataManager<T,INTEGER,STRING,LONG> extends Serializable {
    
    public boolean add(T object);
    
    public boolean update(T object);
    
    public boolean delete(T object);
    
    public T findById(LONG id);
    
    public Collection<T> find(STRING text);
    
    public Collection<T> findInterval(INTEGER from, INTEGER count);
    
    public Collection<T> findAll();
    
}
