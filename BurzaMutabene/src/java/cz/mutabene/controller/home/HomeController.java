/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.home;

import cz.mutabene.model.entity.AddressEntity;
import cz.mutabene.model.entity.CenterEntity;
import cz.mutabene.model.entity.GenderEntity;
import cz.mutabene.model.entity.RegionEntity;
import cz.mutabene.model.entity.UserEntity;
import cz.mutabene.model.entity.UserRoleEntity;
import cz.mutabene.service.manager.AddressManager;
import cz.mutabene.service.manager.CardManager;
import cz.mutabene.service.manager.CenterManager;
import cz.mutabene.service.manager.RegionManager;
import cz.mutabene.service.manager.UserManager;
import cz.mutabene.service.manager.UserRoleManager;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 *
 * @author stenlik
 */
@Controller("homeController")
public class HomeController {
    
    CenterManager centerManager;
    
    RegionManager regionManager;
    
    AddressManager addressManager;
    
    UserRoleManager userRoleManager;
    
    UserManager userManager;
    
    CardManager cardManager;
    
    @RequestMapping(value="/index.htm", method=RequestMethod.GET)
    public String index() throws Exception{
        return "Home/index";
    }
    
    @RequestMapping(value="/about.htm", method=RequestMethod.GET)
    public String about() throws Exception{
        return "Home/about";
    }
    
    @RequestMapping(value="/init.htm", method=RequestMethod.GET)
    public String init() throws Exception{
    RegionEntity praha = new RegionEntity();
    praha.setName("Praha");
    praha.setRegion(praha);
    regionManager.add(praha);
    RegionEntity praha1 = new RegionEntity();
    praha1.setName("Praha 1");
    praha1.setRegion(praha);
    regionManager.add(praha1);
    
    AddressEntity adresa = new AddressEntity();
    adresa.setCity("Praha");
    adresa.setStreet("Vodičkova 6");
    adresa.setZipCode("110 00");
    adresa.setRegion(praha1);
    addressManager.add(adresa);
    
    CenterEntity centrum = new CenterEntity();
    centrum.setName("Centrum 1");
    centrum.setDescription("Centrum pro rodiny");
    centrum.setAddress(adresa);
    centerManager.add(centrum);
    
    UserRoleEntity role1 = new UserRoleEntity("ROLE_ADMIN", "Administrator");
    UserRoleEntity role2 = new UserRoleEntity("ROLE_USER", "Uzivatel");
    userRoleManager.add(role1);
    userRoleManager.add(role2);
    
    UserEntity user = new UserEntity();
    user.setActive(false);
    user.setFirstname("František");
    user.setSurname("Hruška");
    user.setEmail("frantisek.h@seznam.cz");
    user.setGender(GenderEntity.MALE);
    user.setTelephoneNumber("737323111");
    user.setPassword("heslo");
    Set<UserRoleEntity> roles = new LinkedHashSet<UserRoleEntity>();
    roles.add(role1);
    roles.add(role2);
    user.setRoleIT(roles);
    user.setAddress(adresa);
    user.setCenter(centrum);
    userManager.add(user);
    
    return "Home/index";
    }

    public @Autowired void setCenterManager(CenterManager centerManager) {
        this.centerManager = centerManager;
    }

    public @Autowired void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    public @Autowired void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }

    public @Autowired void setUserRoleManager(UserRoleManager userRoleManager) {
        this.userRoleManager = userRoleManager;
    }

    public @Autowired void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public @Autowired void setCardManager(CardManager cardManager) {
        this.cardManager = cardManager;
    }
    
    
    
    
    
    
    
}
