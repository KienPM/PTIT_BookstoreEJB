package sessionbean.book;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.book.Book;
import entity.book.Category;

/**
 * Session Bean implementation class CategorySessionBean
 */
@Stateless
public class CategorySessionBean implements CategorySessionBeanRemote {
	@PersistenceContext(unitName = "BookstoreEJB")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CategorySessionBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Category> findAll() {
		ArrayList<Category> list = new ArrayList<>();

		String hql = "SELECT c FROM Category c";
		list = (ArrayList<Category>) em.createQuery(hql).getResultList();

		return list;
	}

}
