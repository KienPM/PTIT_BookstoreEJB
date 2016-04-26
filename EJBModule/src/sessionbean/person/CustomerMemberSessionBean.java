package sessionbean.person;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.person.CustomerMember;

/**
 * Session Bean implementation class CustomerMemberSessionBean
 */
@Stateless
public class CustomerMemberSessionBean implements CustomerMemberSessionBeanRemote {
	@PersistenceContext(unitName = "BookstoreEJB")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CustomerMemberSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CustomerMember checkLogin(String username, String password) {
		String hql = "FROM CustomerMember c WHERE c.username = :username";
		try {
			CustomerMember c = (CustomerMember) em.createQuery(hql).setParameter("username", username)
					.getSingleResult();
			if (c.getPassword().equals(password)) {
				return c;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

}
