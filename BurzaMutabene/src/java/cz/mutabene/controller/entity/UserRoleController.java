/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.entity;

import cz.mutabene.controller.entity.interfaces.IEntityController;
import cz.mutabene.model.entity.UserRoleEntity;
import cz.mutabene.service.manager.UserRoleManager;
import java.util.Collection;
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
@RequestMapping(value="admin/userRole/")
public class UserRoleController implements IEntityController<UserRoleEntity, Long, ModelMap, String, BindingResult> {
    
    private final String PATH_VIEW = "Entity/UserRole";
    
    UserRoleManager userRoleManager;
    
    @RequestMapping(value="show.htm", method= RequestMethod.GET)
    public String show(ModelMap m) {
        Collection<UserRoleEntity> allRoles = userRoleManager.findAll();
        m.addAttribute("allRoles", allRoles);
        return PATH_VIEW+"/show";
    }

    @RequestMapping(value="add.htm", method= RequestMethod.GET)
    public String add(UserRoleEntity formModel, ModelMap m) {
        m.addAttribute("formModel", formModel);
        return PATH_VIEW+"/add";
    }

    @RequestMapping(value="edit.htm", method= RequestMethod.GET)
    public String edit(@RequestParam(value="id",required = false) Long id, ModelMap m) {
        if(id == null){
            m.addAttribute("errorMessage", "Žádný objekt pro editaci.");
            return PATH_VIEW+"/show";
        }
        
        UserRoleEntity formModel = userRoleManager.findById(id);

        if(formModel == null){
            m.addAttribute("errorMessage", "Objekt s id = "+id+" neexistuje.");
            return PATH_VIEW+"/show";
        }
        m.addAttribute("formModel", formModel);
            return PATH_VIEW+"/edit";
    }

    @RequestMapping(value="delete.htm", method= RequestMethod.GET)
    public String delete(@RequestParam(value="id",required = false) Long id, ModelMap m) {
        if(id == null){
        m.addAttribute("errorMessage", "Žádný objekt pro smazání.");
        return PATH_VIEW+"/show";
        }
        userRoleManager.delete(userRoleManager.findById(id));
        Collection<UserRoleEntity> allRoles = userRoleManager.findAll();
        m.addAttribute("allRoles", allRoles);
        return PATH_VIEW+"/show";
    }

    @RequestMapping(value="submit.htm", method= RequestMethod.POST)
    public String submit(@ModelAttribute("formModel") UserRoleEntity formModel, BindingResult result, ModelMap m) {
            userRoleManager.add(formModel); //TODO pridat validator
            Collection<UserRoleEntity> allRoles = userRoleManager.findAll();
            m.addAttribute("allRoles", allRoles);
            return PATH_VIEW+"/show";
    }

    @RequestMapping(value="save.htm", method= RequestMethod.POST)
    public String save(@ModelAttribute("formModel") UserRoleEntity formModel, BindingResult result, ModelMap m) {
            userRoleManager.update(formModel); //TODO pridat validator
            Collection<UserRoleEntity> allRoles = userRoleManager.findAll();
            m.addAttribute("allRoles", allRoles);
            return PATH_VIEW+"/show";
    }
    
    public @Autowired void setUserRoleManager(UserRoleManager userRoleManager) {
        this.userRoleManager = userRoleManager;
    }
}
