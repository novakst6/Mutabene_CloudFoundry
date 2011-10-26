/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.UserEntity;
import java.util.Collection;
import java.util.List;
import javax.management.Query;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */
@Service("userManager")
public class UserManager extends GenericDataManager<UserEntity> {

    @Override
    public boolean add(UserEntity object) {
        try{
        hibTempl.save(object);
        return true;
        } catch(Exception e){
        return false;
        }
    }

    @Override
    public boolean update(UserEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(UserEntity object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UserEntity findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<UserEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<UserEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<UserEntity> findAll() {
        return hibTempl.loadAll(UserEntity.class);
    }
    
    public UserEntity findByLogin(String login){
        try{
        List<UserEntity> users = hibTempl.find("from UserEntity as user where user.login like ? ", login);
        if(users.isEmpty()){
            return null;
        }
        return users.get(0);
        } catch (Exception e){
            System.out.println("CHYBA V HLEDANi UZIVATELE PODLE LOGINU");
            return null;
        }
    }
    
}
