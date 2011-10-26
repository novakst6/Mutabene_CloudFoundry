/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.RegionEntity;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */

@Service("regionManager")
public class RegionManager extends GenericDataManager<RegionEntity> {

    @Override
    public boolean add(RegionEntity object) {
        try {
            hibTempl.save(object);
            System.out.println(object.getName());
            System.out.println("SAVE");
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(RegionEntity object) {
       try{
            RegionEntity region = findById(object.getId());
            region.setName(object.getName());
            region.setRegion(object.getRegion());
            hibTempl.update(region);
            hibTempl.flush();
            return true;   
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(RegionEntity object) {
        try{
            hibTempl.delete(object);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public RegionEntity findById(Long id) {
        try{
         List<RegionEntity> region = hibTempl.find("from RegionEntity as region where region.id like ? ", id);
         if(!region.isEmpty()){
         return region.get(0);
         } else {
         return null;
         }
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Collection<RegionEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<RegionEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<RegionEntity> findAll() {
       return hibTempl.loadAll(RegionEntity.class);
    }
    
}
