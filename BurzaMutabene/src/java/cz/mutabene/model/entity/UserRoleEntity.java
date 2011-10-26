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
@Table(name = "ROLES_IT")
public class UserRoleEntity implements Serializable {
    private Long id;
    private String name;
    private String description;

    public UserRoleEntity() {
    }

    public UserRoleEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_IT_ID")
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

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

}
