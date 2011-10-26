/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;

import cz.mutabene.model.entity.UserRoleEntity;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author stenlik
 */
@Service("roleITManager")
public class UserRoleManager extends GenericDataManager<UserRoleEntity> {

    @Override
    public boolean add(UserRoleEntity object) {
        try{
        hibTempl.save(object);
        return true;
        } catch(Exception e){
        return false;
        }
    }

    @Override
    public boolean update(UserRoleEntity object) {
        try{
            UserRoleEntity role = findById(object.getId());
            role.setName(object.getName());
            role.setDescription(object.getDescription());
            hibTempl.update(role);
            hibTempl.flush();
            return true;   
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(UserRoleEntity object) {
        try{
            hibTempl.delete(object);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public UserRoleEntity findById(Long id) {
        try{
         List<UserRoleEntity> role = hibTempl.find("from UserRoleEntity as role where role.id like ? ", id);
         if(!role.isEmpty()){
         return role.get(0);
         } else {
         return null;
         }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<UserRoleEntity> find(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<UserRoleEntity> findInterval(Integer from, Integer count) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<UserRoleEntity> findAll() {
        return hibTempl.loadAll(UserRoleEntity.class);
    }
    
}
