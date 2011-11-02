/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.security;

import cz.mutabene.model.entity.UserEntity;
import cz.mutabene.service.manager.UserManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author stenlik
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

    private @Autowired UserManager userManager;
    
    private @Autowired Assembler assembler;
    
    @Override @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException, DataAccessException {
       
            //UserDetails userDetails = null;
            UserEntity user = userManager.findByEmail(string);
            try{
                System.out.println("Found: "+user.getEmail());
            } catch(Exception e){
                System.out.println("Not found. "+string);
            }
            if(user == null){
                throw new UsernameNotFoundException("User not found.");
            }
            return assembler.buildUserFromUserEntity(user);

    }

    public void setAssembler(Assembler assembler) {
        this.assembler = assembler;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
}
