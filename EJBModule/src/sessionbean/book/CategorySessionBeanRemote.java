package sessionbean.book;

import java.util.List;

import javax.ejb.Remote;

import entity.book.Category;

@Remote
public interface CategorySessionBeanRemote {
	public List<Category> findAll();
}
