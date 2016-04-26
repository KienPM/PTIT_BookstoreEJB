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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetList")
public class GetList extends HttpServlet {

	@EJB
	BookSessionBeanRemote bookSessionBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object[] result = new Object[2];
		try {
			List<Book> list = bookSessionBean.findAll();
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
}
