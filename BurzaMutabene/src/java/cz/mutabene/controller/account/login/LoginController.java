/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.account.login;




import cz.mutabene.model.forms.login.LoginFormModel;
import cz.mutabene.model.forms.login.LoginFormValidator;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 *
 * @author Anysek
 */
@Controller("loginController")
public class LoginController {
    private LoginFormValidator loginFormValidator;


    public @Autowired void setValidator(LoginFormValidator loginFormValidator) {
        this.loginFormValidator = loginFormValidator;
    }

    @RequestMapping(value="/login.htm", method= RequestMethod.GET)
    public String login(LoginFormModel loginFormModel, ModelMap map){
        map.addAttribute("loginFormModel", loginFormModel);
        return "Account/login";
    }

//    @RequestMapping(value="/submitLogin.htm",method= RequestMethod.POST)
//    public String submitLogin(LoginFormModel loginFormModel, BindingResult result){
//        loginFormValidator.validate(loginFormModel, result);
//        if(result.hasErrors()){
//            return "Account/login";
//        }
//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
//        User user = new User(loginFormModel.getUsername(), loginFormModel.getPassword(), true, true, true, true, authorities);
//        return "Home/index";
//    }
//    
//   
  
}
