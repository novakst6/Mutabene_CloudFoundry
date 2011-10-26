/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.ArticleEntity;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */
@Service("articleManager")
public class ArticleManager extends GenericDataManager<ArticleEntity> {

    @Override
    public boolean add(ArticleEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(ArticleEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(ArticleEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArticleEntity findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ArticleEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ArticleEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ArticleEntity> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
