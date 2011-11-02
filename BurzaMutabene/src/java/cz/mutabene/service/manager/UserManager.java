/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.GenderEntity;
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
        try {
        hibTempl.save(object);
        return true;
        } catch(Exception e){
        return false;
        }
    }

    @Override
    public boolean update(UserEntity object) {
        
         try{
            UserEntity user = findById(object.getId());
            user.setActive(object.isActive());
            user.setAddress(object.getAddress());
            user.setCenter(object.getCenter());
            user.setEmail(object.getEmail());
            user.setFirstname(object.getFirstname());
            user.setGender(object.getGender());
//            user.setLogin(object.getLogin());
            user.setRoleIT(object.getRoleIT());
            user.setSurname(object.getSurname());
            user.setPassword(object.getPassword());
            user.setTelephoneNumber(object.getTelephoneNumber());
            hibTempl.update(user);
            hibTempl.flush();
            return true;   
        } catch (Exception e){
             System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(UserEntity object) {
        try{
            hibTempl.delete(object);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public UserEntity findById(Long id) {
         try{
         List<UserEntity> user = hibTempl.find("from UserEntity as user where user.id like ? ", id);
         if(!user.isEmpty()){
         return user.get(0);
         } else {
         return null;
         }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
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
    
    public UserEntity findByEmail(String email){
        try{
        List<UserEntity> users = hibTempl.find("from UserEntity as user where user.email like ? ", email);
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
