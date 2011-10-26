/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.service.manager;



import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import cz.mutabene.service.interfaces.IDataManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author stenlik
 */

public abstract class GenericDataManager<T> implements IDataManager<T, Integer, String, Long> {
    
    Session session = null;

    private SessionFactory sessionFactory = null;

    protected  HibernateTemplate hibTempl;

    
    public @Autowired void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.hibTempl = new HibernateTemplate(sessionFactory);
    }
}
