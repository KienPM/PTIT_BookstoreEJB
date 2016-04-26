package sessionbean.book;

import java.util.List;

import javax.ejb.Remote;

import entity.book.Book;

@Remote
public interface BookSessionBeanRemote {
	public List<Book> findAll();
	public Book findByID(int id);
	public List<Book> findByCategory(int categoryID);
	public List<Book> findByKey(String key);
}
