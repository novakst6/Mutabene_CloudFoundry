/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.entity;

import cz.mutabene.controller.entity.interfaces.IEntityController;
import cz.mutabene.model.entity.AddressEntity;
import cz.mutabene.service.manager.AddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

/**
 *
 * @author stenlik
 */
public class AddressController implements IEntityController<AddressEntity, Long, ModelMap, String, BindingResult> {

    AddressManager addressManager;
    
    public String show(ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String add(AddressEntity formModel, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String edit(Long id, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String delete(Long id, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String submit(AddressEntity formModel, BindingResult result, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String save(AddressEntity formModel, BindingResult result, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public @Autowired void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }
    
    
}
