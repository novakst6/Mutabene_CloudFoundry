/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.entity;

import cz.mutabene.controller.entity.interfaces.IEntityController;
import cz.mutabene.model.entity.CardCategoryEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author stenlik
 */
@Controller
@RequestMapping(value="admin/cardCategory")
public class CardCategoryController implements IEntityController<CardCategoryEntity, Long, ModelMap, String, BindingResult> {

    public String show(ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String add(CardCategoryEntity formModel, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String edit(Long id, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String delete(Long id, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String submit(CardCategoryEntity formModel, BindingResult result, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String save(CardCategoryEntity formModel, BindingResult result, ModelMap m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
