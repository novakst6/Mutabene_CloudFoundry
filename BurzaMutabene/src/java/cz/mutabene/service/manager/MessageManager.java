/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.MessageEntity;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */
@Service("messageManager")
public class MessageManager extends GenericDataManager<MessageEntity> {

    @Override
    public boolean add(MessageEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(MessageEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(MessageEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MessageEntity findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<MessageEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<MessageEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<MessageEntity> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
