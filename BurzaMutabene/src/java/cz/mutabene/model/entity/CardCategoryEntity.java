/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author stenlik
 */
@Entity
public class CardCategoryEntity extends OfferObjectCategory{
    
    private String description;
    private CardCategoryEntity cardCategory;
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne @PrimaryKeyJoinColumn
    public CardCategoryEntity getCardCategory() {
        return cardCategory;
    }

    public void setCardCategory(CardCategoryEntity cardCategory) {
        this.cardCategory = cardCategory;
    }
    
    
}
