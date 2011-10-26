/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mutabene.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Anysek
 */
@Entity
@Table(name = "OFFERS")
public class OfferEntity implements Serializable {
    private Long id;
    private String text;
    private String title;
    private Date dateOfInsert;
    private UserEntity user;
    private OfferTypeEntity offerType;
    private OfferStateEntity offerState;
    private CardEntity card;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OFFER_ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DATE_OF_INSERT")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDate() {
        return dateOfInsert;
    }

    public void setDate(Date dateOfInsert) {
        this.dateOfInsert = dateOfInsert;
    }

    @Column(name = "TEXT")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //@Column(name = "CARD_ID")
    @ManyToOne @PrimaryKeyJoinColumn
    public CardEntity getCard() {
        return card;
    }

    public void setCard(CardEntity card) {
        this.card = card;
    }

    //@Column(name = "OFFER_STATE_ID")
    @ManyToOne @PrimaryKeyJoinColumn
    public OfferStateEntity getOfferState() {
        return offerState;
    }

    public void setOfferState(OfferStateEntity offerState) {
        this.offerState = offerState;
    }

    //@Column(name = "OFFER_TYPE_ID")
    @ManyToOne @PrimaryKeyJoinColumn
    public OfferTypeEntity getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferTypeEntity offerType) {
        this.offerType = offerType;
    }

    //@Column(name = "USER_ID")
    @ManyToOne @PrimaryKeyJoinColumn
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
