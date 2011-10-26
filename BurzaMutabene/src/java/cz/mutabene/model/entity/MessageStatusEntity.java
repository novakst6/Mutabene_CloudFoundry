/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mutabene.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Anysek
 */
@Entity
@Table(name = "MESSAGE_STATUSES")
public class MessageStatusEntity implements Serializable {
    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_STATUS_ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
