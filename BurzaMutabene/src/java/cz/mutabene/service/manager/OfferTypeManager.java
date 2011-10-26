/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.OfferTypeEntity;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */
@Service("offerTypeManager")
public class OfferTypeManager extends GenericDataManager<OfferTypeEntity> {

    @Override
    public boolean add(OfferTypeEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(OfferTypeEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(OfferTypeEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OfferTypeEntity findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<OfferTypeEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<OfferTypeEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<OfferTypeEntity> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
