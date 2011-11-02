/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.entity;

import cz.mutabene.controller.entity.interfaces.IEntityController;
import cz.mutabene.model.entity.AddressEntity;
import cz.mutabene.model.entity.CenterEntity;
import cz.mutabene.model.entity.GenderEntity;
import cz.mutabene.model.entity.UserEntity;
import cz.mutabene.model.entity.UserRoleEntity;
import cz.mutabene.model.forms.entity.UserModel;
import cz.mutabene.service.manager.AddressManager;
import cz.mutabene.service.manager.CenterManager;
import cz.mutabene.service.manager.RegionManager;
import cz.mutabene.service.manager.UserManager;
import cz.mutabene.service.manager.UserRoleManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author stenlik
 */

@Controller
@RequestMapping(value="admin/user/")
public class UserController implements IEntityController<UserModel, Long, ModelMap, String, BindingResult> {

    UserManager userManager;
    CenterManager centerManager;
    AddressManager addressManager;
    RegionManager regionManager;
    UserRoleManager userRoleManager;
    
    private final String PATH_VIEW = "Entity/User";
    
    @RequestMapping(value="show.htm", method= RequestMethod.GET)
    public String show(ModelMap m) {
        Collection<UserEntity> allUsers = userManager.findAll();
        m.addAttribute("allUsers", allUsers);
        return PATH_VIEW+"/show";
    }

    @RequestMapping(value="add.htm", method= RequestMethod.GET)
    public String add(UserModel formModel, ModelMap m) {
        m.addAttribute("formModel", formModel);
        
        Collection<AddressEntity> allAddress = addressManager.findAll();
        Map<String, String> listAddress = new LinkedHashMap<String, String>();
        for(AddressEntity a: allAddress){
            listAddress.put(a.getId().toString(), a.getStreet()+" "+a.getCity()+", "+a.getZipCode()+", "+a.getRegion().getName());
        }
        m.addAttribute("listAddress", listAddress);
        
        Collection<CenterEntity> allCenters = centerManager.findAll();
        Map<String, String> listCenters = new LinkedHashMap<String, String>();
        for(CenterEntity c: allCenters){
            listCenters.put(c.getId().toString(), c.getName());
        }
        m.addAttribute("listCenters", listCenters);
        
        Collection<UserRoleEntity> allRoles = userRoleManager.findAll();
        Map<String, String> listRoles = new LinkedHashMap<String, String>();
        for(UserRoleEntity u: allRoles){
            listRoles.put(u.getId().toString(), u.getName());
        }
        m.addAttribute("listRoles", listRoles);
        
        return PATH_VIEW+"/add";
    }

    @RequestMapping(value="edit.htm", method= RequestMethod.GET)
    public String edit(Long id, ModelMap m) {
        UserEntity user;
        try{
            user = userManager.findById(id);
            user.getId();
        }catch(Exception e){
            return show(m);
        }
        
        UserModel formModel = new UserModel();
        formModel.setId(user.getId());
        formModel.setActive(user.isActive());
        formModel.setEmail(user.getEmail());
        formModel.setFirstname(user.getFirstname());
        formModel.setGender(user.getGender().toString());
        formModel.setIdAddress(user.getAddress().getId().toString());
        formModel.setIdCenter(user.getCenter().getId().toString());
        formModel.setPasswd(user.getPassword());
        List<String> roles = new LinkedList<String>();
        for(UserRoleEntity r: user.getRoleIT()){
            roles.add(r.getId().toString());
        }
        formModel.setRoles(roles);
        formModel.setSurname(user.getSurname());
        formModel.setTelNumber(user.getTelephoneNumber());
        
        m.addAttribute("formModel", formModel);
        
        Collection<AddressEntity> allAddress = addressManager.findAll();
        Map<String, String> listAddress = new LinkedHashMap<String, String>();
        for(AddressEntity a: allAddress){
            listAddress.put(a.getId().toString(), a.getStreet()+" "+a.getCity()+", "+a.getZipCode()+", "+a.getRegion().getName());
        }
        m.addAttribute("listAddress", listAddress);
        
        Collection<CenterEntity> allCenters = centerManager.findAll();
        Map<String, String> listCenters = new LinkedHashMap<String, String>();
        for(CenterEntity c: allCenters){
            listCenters.put(c.getId().toString(), c.getName());
        }
        m.addAttribute("listCenters", listCenters);
        
        Collection<UserRoleEntity> allRoles = userRoleManager.findAll();
        Map<String, String> listRoles = new LinkedHashMap<String, String>();
        for(UserRoleEntity u: allRoles){
            listRoles.put(u.getId().toString(), u.getName());
        }
        m.addAttribute("listRoles", listRoles);
        
        return PATH_VIEW+"/edit";
    }

    public String delete(Long id, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @RequestMapping(value="submit.htm", method= RequestMethod.POST)
    public String submit(UserModel formModel, BindingResult result, ModelMap m) {
        UserEntity user = new UserEntity();
        user.setActive(formModel.isActive());
        user.setFirstname(formModel.getFirstname());
        user.setSurname(formModel.getSurname());
        user.setEmail(formModel.getEmail());
        user.setPassword(formModel.getPasswd());
        user.setTelephoneNumber(formModel.getTelNumber());
        user.setGender(GenderEntity.valueOf(formModel.getGender()));
        Long id;
        AddressEntity address;
        CenterEntity center;
        UserRoleEntity role;
        Set<UserRoleEntity> roles = new HashSet<UserRoleEntity>();
        try{
            id = Long.parseLong(formModel.getIdAddress());
            address = addressManager.findById(id);
        }catch (Exception e){
            address = null;
        }
        user.setAddress(address);
        
        try{
            id = Long.parseLong(formModel.getIdCenter());
            center = centerManager.findById(id);
        }catch (Exception e){
            center = null;
        }
        user.setCenter(center);
        
        for(String s: formModel.getRoles()){
            try{
                id = Long.parseLong(s);
                role = userRoleManager.findById(id);
                roles.add(role);
            } catch (Exception e){
                
            }
        }
        user.setRoleIT(roles);
        userManager.add(user);
        return show(m);
    }

    @RequestMapping(value="save.htm", method= RequestMethod.POST)
    public String save(UserModel formModel, BindingResult result, ModelMap m) {
        UserEntity userOrig;
        AddressEntity addressOrig;
        CenterEntity centerOrig;
        UserRoleEntity role;
        Set<UserRoleEntity> roles = new HashSet<UserRoleEntity>();
        Long id;
        try{
            id = formModel.getId();
            userOrig = userManager.findById(id);
        }catch(Exception e){
            userOrig = null;
        }
        try{
            id = Long.parseLong(formModel.getIdAddress());
            addressOrig = addressManager.findById(id);
        }catch(Exception e){
            addressOrig = null;
        }
        try{
            id = Long.parseLong(formModel.getIdCenter());
            centerOrig = centerManager.findById(id);
        }catch(Exception e){
            centerOrig = null;
        }
        try{
            for(String s: formModel.getRoles()){
                try{
                    id = Long.parseLong(s);
                    role = userRoleManager.findById(id);
                    roles.add(role);
                }catch(Exception e){
                
                }
            }
        }catch(Exception e){
        }
        try{
            userOrig.setActive(formModel.isActive());
            userOrig.setAddress(addressOrig);
            userOrig.setCenter(centerOrig);
            userOrig.setEmail(formModel.getEmail());
            userOrig.setFirstname(formModel.getFirstname());
            userOrig.setGender(GenderEntity.valueOf(formModel.getGender()));
            userOrig.setPassword(formModel.getPasswd());
            userOrig.setSurname(formModel.getSurname());
            userOrig.setTelephoneNumber(formModel.getTelNumber());
            userOrig.setRoleIT(roles);
        }catch(Exception e){
        }
        
        userManager.update(userOrig);
        System.out.println("UPDATE");
        return show(m);
    }

    public @Autowired void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    public @Autowired void setCenterManager(CenterManager centerManager) {
        this.centerManager = centerManager;
    }

    public @Autowired void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }

    public @Autowired void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public @Autowired void setUserRoleManager(UserRoleManager userRoleManager) {
        this.userRoleManager = userRoleManager;
    }
    
    
    
    
}
