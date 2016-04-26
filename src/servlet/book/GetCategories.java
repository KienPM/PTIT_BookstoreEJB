package servlet.book;

import com.google.gson.Gson;
import entity.book.Category;
import sessionbean.book.BookSessionBeanRemote;
import sessionbean.book.CategorySessionBeanRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ken on 12/03/2016.
 */
@WebServlet(name = "GetCategories", urlPatterns = "/GetCategories")
public class GetCategories extends HttpServlet {
	@EJB
	CategorySessionBeanRemote categorySessionBean;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object[] result = new Object[2];
		try {
			List<Category> list = categorySessionBean.findAll();
			result[0] = "success";
			result[1] = list;
		} catch (Exception e) {
			result[0] = "fail";
			e.printStackTrace();
		} finally {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(result));
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
