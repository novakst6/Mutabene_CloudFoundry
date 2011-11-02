/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;


/**
 *
 * @author stenlik
 */
@Entity
public class OfferOtherObjectEntity extends OfferObjectEntity {
    private OfferOtherObjectCategory offerOtherObjectCategory;

    @ManyToOne @PrimaryKeyJoinColumn
    public OfferOtherObjectCategory getOfferOtherObjectCategory() {
        return offerOtherObjectCategory;
    }

    public void setOfferOtherObjectCategory(OfferOtherObjectCategory offerOtherObjectCategory) {
        this.offerOtherObjectCategory = offerOtherObjectCategory;
    }
    
    
}
