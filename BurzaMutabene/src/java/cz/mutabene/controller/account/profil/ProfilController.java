/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.account.profil;

import cz.mutabene.model.entity.UserEntity;
import cz.mutabene.model.forms.profil.ProfilModel;
import cz.mutabene.service.manager.OfferManager;
import cz.mutabene.service.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author stenlik
 */
@Controller
@RequestMapping(value="account/")
public class ProfilController {
    
    private final String PATH_VIEW = "Account/Profil";
    
    UserManager userManager;
    
    OfferManager offerManager;
    
    @RequestMapping(value="info.htm", method= RequestMethod.GET)
    public String getInfo(ModelMap m, Authentication aut) throws Exception{
        User user = (User) aut.getPrincipal();
        UserEntity actualUser = userManager.findByEmail(user.getUsername());
        ProfilModel profilModel = new ProfilModel();
        profilModel.setFirstname(actualUser.getFirstname());
        profilModel.setSurname(actualUser.getSurname());
        profilModel.setEmail(actualUser.getEmail());
        profilModel.setTelNumber(actualUser.getTelephoneNumber());
        profilModel.setStreet(actualUser.getAddress().getStreet());
        profilModel.setCity(actualUser.getAddress().getCity());
        profilModel.setZipCode(actualUser.getAddress().getZipCode());
        profilModel.setRegionName(actualUser.getAddress().getRegion().getName());
        profilModel.setCenterName(actualUser.getCenter().getName());
        m.addAttribute("profilModel", profilModel);
        return PATH_VIEW+"/info";
    }

    @RequestMapping(value="userOffers.htm", method= RequestMethod.GET)
    public String getUserOffers(ModelMap m, Authentication aut) throws Exception{
        User user = (User) aut.getPrincipal();
        UserEntity actualUser = userManager.findByEmail(user.getUsername());
        //TODO vzhledat vsechny aktualni inzeraty uzivatele.
        return null;
    }

    public @Autowired void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public @Autowired void setOfferManager(OfferManager offerManager) {
        this.offerManager = offerManager;
    }
    
    
}
