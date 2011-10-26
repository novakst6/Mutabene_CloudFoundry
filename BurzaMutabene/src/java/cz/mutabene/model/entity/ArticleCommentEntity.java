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
 * @author stenlik
 */
@Entity
@Table(name = "ARTICLE_COMMENTS")
public class ArticleCommentEntity implements Serializable {
    private Long id;
    private String subject;
    private String text;
    private UserEntity autor;
    private Date dateOfComment;
    private ArticleEntity article;

    public ArticleCommentEntity() {
    }

    @ManyToOne @PrimaryKeyJoinColumn
    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }

    @ManyToOne @PrimaryKeyJoinColumn
    public UserEntity getAutor() {
        return autor;
    }

    public void setAutor(UserEntity autor) {
        this.autor = autor;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "COMMENT_DATE")
    public Date getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(Date dateOfComment) {
        this.dateOfComment = dateOfComment;
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "COMMENT_SUBJECT")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(name = "COMMENT_TEXT")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
