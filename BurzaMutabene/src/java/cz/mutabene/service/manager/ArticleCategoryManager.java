/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.ArticleCategoryEntity;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */
@Service("articleCategoryManager")
public class ArticleCategoryManager extends GenericDataManager<ArticleCategoryEntity> {

    @Override
    public boolean add(ArticleCategoryEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(ArticleCategoryEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(ArticleCategoryEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArticleCategoryEntity findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ArticleCategoryEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ArticleCategoryEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ArticleCategoryEntity> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
