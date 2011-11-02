/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.entity;

import cz.mutabene.controller.entity.interfaces.IEntityController;
import cz.mutabene.model.entity.AddressEntity;
import cz.mutabene.model.entity.CenterEntity;
import cz.mutabene.model.forms.entity.CenterModel;
import cz.mutabene.service.manager.AddressManager;
import cz.mutabene.service.manager.CenterManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author stenlik
 */
@Controller
@RequestMapping(value="admin/center")
public class CenterController implements IEntityController<CenterModel, Long, ModelMap, String, BindingResult> {

    CenterManager centerManager;
    
    AddressManager addressManager;
    
    private final String PATH_VIEW = "Entity/Center";
       
    @RequestMapping(value="show.htm", method= RequestMethod.GET)
    public String show(ModelMap m) {
     Collection<CenterEntity> allCenters = centerManager.findAll();
        m.addAttribute("allCenters", allCenters);
        return PATH_VIEW+"/show";
    }

    @RequestMapping(value="add.htm", method= RequestMethod.GET)
    public String add(CenterModel formModel, ModelMap m) {
        Collection<AddressEntity> listAddresses = addressManager.findAll();
        Map<String, String> listAddress = new HashMap<String, String>();
        for(AddressEntity a: listAddresses){
             listAddress.put(a.getId().toString(), a.getStreet()+" "+a.getZipCode()+", "+a.getCity()+", "+a.getRegion().getName());
        }
        m.addAttribute("formModel", formModel);
        m.addAttribute("listAddress", listAddress);
        return PATH_VIEW+"/add";
    }
    @RequestMapping(value="edit.htm", method= RequestMethod.GET)
    public String edit(@RequestParam(value="id") Long id, ModelMap m) {
        CenterEntity center;
        try{
            center = centerManager.findById(id);
        }catch (Exception e){
            m.addAttribute("errorMessage", "Objekt s id = "+id+" neexistuje.");
            return PATH_VIEW+"/show";
        }
        
        CenterModel formModel = new CenterModel();
        formModel.setId(center.getId().toString());
        formModel.setName(center.getName());
        formModel.setDescription(center.getDescription());
        formModel.setIdAddress(center.getAddress().getId().toString());
        m.addAttribute("formModel", formModel);
        
        Collection<AddressEntity> listAddresses = addressManager.findAll();
        Map<String, String> listAddress = new HashMap<String, String>();
        for(AddressEntity a: listAddresses){
             listAddress.put(a.getId().toString(), a.getStreet()+" "+a.getZipCode()+", "+a.getCity()+", "+a.getRegion().getName());
        }
        m.addAttribute("listAddress", listAddress);
        return PATH_VIEW+"/edit";
    }
    
    @RequestMapping(value="delete.htm", method= RequestMethod.GET)
    public String delete(@RequestParam(value="id") Long id, ModelMap m) {
        CenterEntity center;
        try{
            center = centerManager.findById(id);
            centerManager.delete(center);
        }catch(Exception e){
        }
        return show(m);
    }
    
    @RequestMapping(value="submit.htm", method= RequestMethod.POST)
    public String submit(CenterModel formModel, BindingResult result, ModelMap m) {
        CenterEntity center = new CenterEntity();
        center.setName(formModel.getName());
        center.setDescription(formModel.getDescription());
        
        AddressEntity address;
        try{
            Long id = Long.parseLong(formModel.getIdAddress());
            address = addressManager.findById(id);
        }catch(Exception e){
            address = null;
        }
        
        center.setAddress(address);
        
        centerManager.add(center);
        return show(m);
    }

    @RequestMapping(value="save.htm", method= RequestMethod.POST)
    public String save(CenterModel formModel, BindingResult result, ModelMap m) {
        AddressEntity address;
        CenterEntity center;
        
        try{
            Long id = Long.parseLong(formModel.getId());
            center = centerManager.findById(id);
            center.setName(formModel.getName());
            center.setDescription(formModel.getDescription());
            try{
                id = Long.parseLong(formModel.getIdAddress());
                address = addressManager.findById(id);
                center.setAddress(address);
            }catch(Exception e){
                center.setAddress(null);
            }
            centerManager.update(center);
        }catch(Exception e){
            
        }
        return show(m);
    }

    public @Autowired void setCenterManager(CenterManager centerManager) {
        this.centerManager = centerManager;
    }

    public @Autowired void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }
    
    
}
