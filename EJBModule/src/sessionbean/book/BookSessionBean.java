package sessionbean.book;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.book.Book;

/**
 * Session Bean implementation class BookSessionBean
 */
@Stateless
public class BookSessionBean implements BookSessionBeanRemote {
    @PersistenceContext(unitName = "BookstoreEJB")
    private EntityManager em;

    /**
     * Default constructor.
     */
    public BookSessionBean() {
        // TODO Auto-generated constructor stub
    }

    public List<Book> findAll() {
        ArrayList<Book> list = new ArrayList<>();

        String hql = "SELECT b FROM Book b";
        list = (ArrayList<Book>) em.createQuery(hql).getResultList();

        return list;
    }

    public Book findByID(int id) {
        String hql = "FROM Book b WHERE b.id = :id";
        return (Book) em.createQuery(hql).setParameter("id", id).getSingleResult();
    }

    public List<Book> findByCategory(int categoryID) {
        ArrayList<Book> list = new ArrayList<>();

        String hql = "FROM Book b WHERE b.category.id = :categoryID";
        list = (ArrayList<Book>) em.createQuery(hql).setParameter("categoryID", categoryID).getResultList();

        return list;
    }

    public List<Book> findByKey(String key) {
        ArrayList<Book> list = new ArrayList<>();

        String hql = "FROM Book b WHERE b.title LIKE :key OR b.author.name LIKE :key";
        list = (ArrayList<Book>) em.createQuery(hql).setParameter("key", "%" + key + "%").getResultList();

        return list;
    }


}
