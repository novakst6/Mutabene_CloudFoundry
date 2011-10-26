/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.CenterEntity;
import java.util.Collection;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */

@Service("centerManager")
public class CenterManager extends GenericDataManager<CenterEntity> {

    @Override
    public boolean add(CenterEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(CenterEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(CenterEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CenterEntity findById(Long id) {
        return hibTempl.load(CenterEntity.class, id);
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
