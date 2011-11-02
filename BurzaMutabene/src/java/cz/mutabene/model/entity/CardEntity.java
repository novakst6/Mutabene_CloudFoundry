/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mutabene.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Anysek
 */
@Entity
@Table(name="CARDS")
public class CardEntity extends OfferObjectEntity {
    private Long id;
    private String name;
    private String description;
    private String serialNumber;
    private int price;
    private CardCategoryEntity cardCategoryEntity;
    private byte[] picture;
    

    @Column(name = "SERIAL_NUMBER")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    @Column(name = "PRICE")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToOne @PrimaryKeyJoinColumn
    public CardCategoryEntity getCardCategoryEntity() {
        return cardCategoryEntity;
    }

    public void setCardCategoryEntity(CardCategoryEntity cardCategoryEntity) {
        this.cardCategoryEntity = cardCategoryEntity;
    }

    @Lob @Column(length= 102485)
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
    
}
