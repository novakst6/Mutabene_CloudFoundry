/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author stenlik
 */
@Entity
@Table(name = "GENDERS")
public enum GenderEntity {
    MALE, FEMALE
}
