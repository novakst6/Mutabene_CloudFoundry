/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.entity;

import cz.mutabene.model.forms.entity.RegionModel;
import cz.mutabene.controller.entity.interfaces.IEntityController;
import cz.mutabene.model.entity.RegionEntity;
import cz.mutabene.service.manager.RegionManager;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author stenlik
 */
@Controller
@RequestMapping("admin/region/")
public class RegionController implements IEntityController<RegionModel, Long, ModelMap, String, BindingResult> {

    
    RegionManager regionManager;
    
    private final String PATH_VIEW = "Entity/Region";
    
    @RequestMapping(value="show.htm", method= RequestMethod.GET)
    public String show(ModelMap m) {
        Collection<RegionEntity> allRegions = regionManager.findAll();
        m.addAttribute("allRegions", allRegions);
        return PATH_VIEW+"/show";
    }
    
    @RequestMapping(value="add.htm", method= RequestMethod.GET)
    public String add(RegionModel formModel, ModelMap m) {
        m.addAttribute("formModel", formModel);
        
        Collection<RegionEntity> allRegions = regionManager.findAll();
        Map<String, String>  listRegion = new LinkedHashMap<String, String>();
        for(RegionEntity r: allRegions){
            listRegion.put(r.getId().toString(), r.getName());
        }
        m.addAttribute("listRegions", listRegion);
        return PATH_VIEW+"/add";
    }

    @RequestMapping(value="edit.htm", method= RequestMethod.GET)
    public String edit(@RequestParam(value="id") Long id, ModelMap m) {
        if(id == null){
            m.addAttribute("errorMessage", "Žádný objekt pro editaci.");
            return PATH_VIEW+"/show";
        }       
        RegionEntity regionModel = regionManager.findById(id);
        
        if(regionModel == null){
            m.addAttribute("errorMessage", "Objekt s id = "+id+" neexistuje.");
            return PATH_VIEW+"/show";
        }
        
        RegionModel formModel = new RegionModel();
        formModel.setName(regionModel.getName());
        try{
        formModel.setId(regionModel.getRegion().getId().toString());
        } catch (Exception e){
        
        }
        formModel.setIdOrig(regionModel.getId().toString());
        
        Collection<RegionEntity> allRegions = regionManager.findAll();
        Map<String, String>  listRegion = new LinkedHashMap<String, String>();
        for(RegionEntity r: allRegions){
            listRegion.put(r.getId().toString(), r.getName());
        }
        m.addAttribute("listRegions", listRegion);
        m.addAttribute("formModel", formModel);
            return PATH_VIEW+"/edit";
    }

    @RequestMapping(value="delete.htm", method= RequestMethod.GET)
    public String delete(@RequestParam(value="id") Long id, ModelMap m) {
        
        boolean isSingle = true; 
        Collection<RegionEntity> allRegions = regionManager.findAll();
        RegionEntity toDelete = regionManager.findById(id);
                
        if(toDelete != null){
            for(RegionEntity r: allRegions){               
                if(r != null && r.getRegion() != null){                  
                    if(id.equals(r.getRegion().getId())){
                        isSingle = false;
                    }
                }
            }
        }
        if(isSingle){

        regionManager.delete(toDelete);
        } else {
        m.addAttribute("msgerr", "Na objekt jsou vázané další objekty");
        }
        allRegions = regionManager.findAll();
        m.addAttribute("allRegions", allRegions);
        
        return PATH_VIEW+"/show";
    }

    @RequestMapping(value="submit.htm", method= RequestMethod.POST)
    public String submit(@ModelAttribute(value="formModel") RegionModel formModel, BindingResult result, ModelMap m) {
        RegionEntity region = new RegionEntity();
        region.setName(formModel.getName());
        try{
            Long id = Long.parseLong(formModel.getId());
            RegionEntity parent = regionManager.findById(id);
            region.setRegion(parent);
        } catch (Exception e){
            region.setRegion(region);
        }
        System.out.println(region.getName()+region.getRegion());
        regionManager.add(region);
        Collection<RegionEntity> allRegions = regionManager.findAll();
        m.addAttribute("allRegions", allRegions);
        return PATH_VIEW+"/show";
    }
    
    @RequestMapping(value="save.htm", method= RequestMethod.POST)
    public String save(@ModelAttribute(value="formModel") RegionModel formModel, BindingResult result, ModelMap m) {
        RegionEntity regionOrig;
        RegionEntity parent;
        try{
            Long id = Long.parseLong(formModel.getIdOrig());
            regionOrig = regionManager.findById(id);          
            regionOrig.setName(formModel.getName());
        } catch (Exception e){
            return PATH_VIEW+"/show";
        }
        
        try{
            Long idParent = Long.parseLong(formModel.getId());
            parent = regionManager.findById(idParent);
            regionOrig.setRegion(parent);
        } catch (Exception e){
            regionOrig.setRegion(regionOrig);
        }
            regionManager.update(regionOrig); //TODO pridat validator
            Collection<RegionEntity> allRegions = regionManager.findAll();
            m.addAttribute("allRegions", allRegions);
            return PATH_VIEW+"/show";
    }
    
    public @Autowired void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }
    
}
