/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.MessageStatusEntity;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */
@Service("messageStatusManager")
public class MessageStatusManager extends GenericDataManager<MessageStatusEntity> {

    @Override
    public boolean add(MessageStatusEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(MessageStatusEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(MessageStatusEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MessageStatusEntity findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<MessageStatusEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<MessageStatusEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<MessageStatusEntity> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
