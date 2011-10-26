/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.ArticleCommentEntity;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */
@Service("articleCommentManager")
public class ArticleCommentManager extends GenericDataManager<ArticleCommentEntity> {

    @Override
    public boolean add(ArticleCommentEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(ArticleCommentEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(ArticleCommentEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArticleCommentEntity findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ArticleCommentEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ArticleCommentEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<ArticleCommentEntity> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
