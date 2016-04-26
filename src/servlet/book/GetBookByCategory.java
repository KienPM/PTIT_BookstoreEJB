package servlet.book;

import com.google.gson.Gson;
import entity.book.Book;
import sessionbean.book.BookSessionBeanRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken on 16/03/2016.
 */
@WebServlet(name = "GetBookByCategory", urlPatterns = "/GetBookByCategory")
public class GetBookByCategory extends HttpServlet {
	@EJB
	BookSessionBeanRemote bookSessionBean;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("idCategory"));
		Object[] result = new Object[2];
		try {
			List<Book> list = bookSessionBean.findByCategory(categoryID);
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
