/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.OfferStateEntity;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */
@Service("offerStateManager")
public class OfferStateManager extends GenericDataManager<OfferStateEntity> {

    @Override
    public boolean add(OfferStateEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(OfferStateEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(OfferStateEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OfferStateEntity findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<OfferStateEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<OfferStateEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<OfferStateEntity> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
