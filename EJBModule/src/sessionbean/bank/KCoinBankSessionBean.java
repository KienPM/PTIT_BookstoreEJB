package sessionbean.bank;

import entity.bank.KcoinBank;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ken on 30/04/2016.
 */
@Stateless(name = "KCoinBankSessionEJB")
public class KCoinBankSessionBean implements KcoinBankSessionBeanRemote {
    @PersistenceContext(unitName = "BookstoreEJB")
    private EntityManager em;

    public KCoinBankSessionBean() {
    }

    @Override
    public int save(KcoinBank kcoinBank) {
        em.persist(kcoinBank);
        return kcoinBank.getId();
    }
}
