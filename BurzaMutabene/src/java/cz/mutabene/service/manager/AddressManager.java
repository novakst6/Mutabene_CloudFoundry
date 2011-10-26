/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.AddressEntity;
import java.util.Collection;

import org.springframework.stereotype.Service;


/**
 *
 * @author stenlik
 */


@Service("addressManager")
public class AddressManager extends GenericDataManager<AddressEntity> {

    @Override
    public boolean add(AddressEntity object) {
        try{
        hibTempl.save(object);
        return true;
        } catch (Exception e) {
        return false;
        }
    }

    @Override
    public boolean update(AddressEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(AddressEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AddressEntity findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<AddressEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<AddressEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<AddressEntity> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
