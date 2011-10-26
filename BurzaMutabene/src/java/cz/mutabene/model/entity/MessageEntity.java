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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Anysek
 */
@Entity
@Table(name = "MESSAGES")
public class MessageEntity implements Serializable {
    private Long id;
    private Date dateOfSend;
    private String text;
    private String subject;
    private MessageStatusEntity messageStatus;
    private OfferEntity offer;
    private UserEntity fromUser;
    private UserEntity toUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DATE_OF_SEND")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDate() {
        return dateOfSend;
    }

    public void setDate(Date dateOfSend) {
        this.dateOfSend = dateOfSend;
    }

    @Column(name = "SUBJECT")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(name = "TEXT")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //@Column(name = "FROM_USER_ID")
    @ManyToOne @PrimaryKeyJoinColumn
    public UserEntity getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserEntity fromUser) {
        this.fromUser = fromUser;
    }

    //@Column(name = "MESSAGE_STATUS_ID")
    @ManyToOne @PrimaryKeyJoinColumn
    public MessageStatusEntity getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatusEntity messageStatus) {
        this.messageStatus = messageStatus;
    }

    //@Column(name = "OFFER_ID")
    @OneToOne @PrimaryKeyJoinColumn
    public OfferEntity getOffer() {
        return offer;
    }

    public void setOffer(OfferEntity offer) {
        this.offer = offer;
    }

    //@Column(name = "TO_USER_ID")
    @ManyToOne @PrimaryKeyJoinColumn
    public UserEntity getToUser() {
        return toUser;
    }

    public void setToUser(UserEntity toUser) {
        this.toUser = toUser;
    }
    
}
