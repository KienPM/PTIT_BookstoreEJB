package sessionbean.person;

import entity.person.FullName;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ken on 30/04/2016.
 */
@Stateless(name = "FullNameSessionEJB")
public class FullNameSessionBean implements FullNameSessionBeanRemote {
    @PersistenceContext(unitName = "BookstoreEJB")
    private EntityManager em;

    public FullNameSessionBean() {
    }

    @Override
    public int save(FullName fullName) {
        em.persist(fullName);
        return fullName.getId();
    }
}
