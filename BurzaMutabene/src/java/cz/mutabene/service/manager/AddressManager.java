/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.AddressEntity;
import java.util.Collection;
import java.util.List;

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
        try{
            AddressEntity address = findById(object.getId());
            
            address.setCity(object.getCity());
            address.setStreet(object.getStreet());
            address.setRegion(object.getRegion());
            address.setZipCode(object.getZipCode());
            
            hibTempl.update(address);
            hibTempl.flush();
            return true;   
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(AddressEntity object) {
        try{
            hibTempl.delete(object);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public AddressEntity findById(Long id) {
        try{
         List<AddressEntity> address = hibTempl.find("from AddressEntity as address where address.id like ? ", id);
         if(!address.isEmpty()){
         return address.get(0);
         } else {
         return null;
         }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
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
        return hibTempl.loadAll(AddressEntity.class);
    }
    
}
