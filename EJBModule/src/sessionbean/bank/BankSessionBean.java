package sessionbean.bank;

import entity.bank.Bank;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ken on 30/04/2016.
 */
@Stateless(name = "BankSessionEJB")
public class BankSessionBean implements BankSessionBeanRemote {
    @PersistenceContext(unitName = "BookstoreEJB")
    private EntityManager em;

    public BankSessionBean() {
    }

    @Override
    public int save(Bank bank) {
        em.persist(bank);
        return bank.getId();
    }
}
