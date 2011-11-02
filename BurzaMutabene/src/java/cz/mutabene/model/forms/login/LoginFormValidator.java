/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mutabene.model.forms.login;

import cz.mutabene.model.entity.UserEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import cz.mutabene.service.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anysek
 */
@Service("loginFormValidator")
@Component
public class LoginFormValidator implements Validator {
    
    private UserManager userManager;

    @Override
    public boolean supports(Class<?> type) {
        if(type.equals(LoginFormModel.class)) return true; else return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        LoginFormModel lfm = (LoginFormModel) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", null, "Není vyplněno uživatelské jméno.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Není vyplněno heslo.");
        
        if(!validateUser(lfm.getUsername(), lfm.getPassword()) && !errors.hasErrors()){
        errors.rejectValue("errors", null, "Chybné jméno nebo heslo !");
        }
        
        
    }

    private boolean validateUser(String login, String pass){
            UserEntity existingUser = userManager.findByEmail(login.toLowerCase());
            if (existingUser == null) {
                return false;
            } else {
                return pass.equals(existingUser.getPassword());
            }

    }
        
    

    public @Autowired void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
