/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.CenterEntity;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */

@Service("centerManager")
public class CenterManager extends GenericDataManager<CenterEntity> {

    @Override
    public boolean add(CenterEntity object) {
        try{
        hibTempl.save(object);
        return true;
        } catch(Exception e){
        return false;
        }
    }

    @Override
    public boolean update(CenterEntity object) {
            try{
            CenterEntity center = findById(object.getId());
            center.setName(object.getName());
            center.setDescription(object.getDescription());
            center.setAddress(object.getAddress());
            hibTempl.update(center);
            hibTempl.flush();
            return true;   
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(CenterEntity object) {
        try{
            hibTempl.delete(object);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public CenterEntity findById(Long id) {
        try{
         List<CenterEntity> center = hibTempl.find("from CenterEntity as center where center.id like ? ", id);
         if(!center.isEmpty()){
         return center.get(0);
         } else {
         return null;
         }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<CenterEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<CenterEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<CenterEntity> findAll() {
        return hibTempl.loadAll(CenterEntity.class);
    }
    
}
