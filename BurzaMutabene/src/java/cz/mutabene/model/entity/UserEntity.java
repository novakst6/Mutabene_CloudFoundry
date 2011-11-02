/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mutabene.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Anysek
 */

@Entity
@Table(name = "USERS")
public class UserEntity implements Serializable {
    private Long id;
    private String firstname;
    private String surname;
    //private String login;
    private String password;
    private GenderEntity gender;
    private String email;
    private String telephoneNumber;
    private Set<UserRoleEntity> roleIT = new HashSet<UserRoleEntity>();
    private CenterEntity center;
    private AddressEntity address;
    private boolean active;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "U_FIRST_NAME")
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "U_SURNAME")
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "U_PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Column(name= "U_LOGIN")
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }

    @Column(name = "U_EMAIL")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name= "U_TELEPHONE_NUMBER")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Column(name = "U_GENDER")
    public GenderEntity getGender() {
        return gender;
    }
    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }

    //@Column(name = "ROLE_IT_ID")
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "USER_ROLES_IT", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns={@JoinColumn(name = "ROLE_IT_ID")})
    public Set<UserRoleEntity> getRoleIT() {
        return roleIT;
    }

    public void setRoleIT(Set<UserRoleEntity> roleIT) {
        this.roleIT = roleIT;
    }

    //@Column(name = "CENTER_ID")
    @ManyToOne @PrimaryKeyJoinColumn
    public CenterEntity getCenter() {
        return center;
    }

    public void setCenter(CenterEntity center) {
        this.center = center;
    }


    @ManyToOne @PrimaryKeyJoinColumn
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    @Column(name = "ACTIVE")
    public boolean isActive() {
        return active;
    }
   public void setActive(boolean active) {
        this.active = active;
    }
}