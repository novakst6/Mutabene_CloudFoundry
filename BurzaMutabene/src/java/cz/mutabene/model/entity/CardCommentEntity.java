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
@Table(name = "CARD_COMMENTS")
public class CardCommentEntity implements Serializable {
    private Long id;
    private Date dateOfComment;
    private String text;
    private CardEntity card;
    private UserEntity user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_COMMENT_ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DATE_OF_COMMENT")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(Date dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    @Column(name = "TEXT")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //@Column(name = "CARD_ID")
    @ManyToOne @PrimaryKeyJoinColumn
    public CardEntity getCard() {
        return card;
    }

    public void setCard(CardEntity card) {
        this.card = card;
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
