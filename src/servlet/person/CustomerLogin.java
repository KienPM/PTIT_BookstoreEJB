package servlet.person;

import com.google.gson.Gson;
import entity.person.CustomerMember;
import sessionbean.book.BookSessionBeanRemote;
import sessionbean.person.CustomerMemberSessionBeanRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ken on 25/03/2016.
 */
@WebServlet(name = "CustomerLogin", urlPatterns = "/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	@EJB
	CustomerMemberSessionBeanRemote customerMemberSessionBean;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Object[] result = new Object[2];
		try {
			CustomerMember c = customerMemberSessionBean.checkLogin(username, password);
			if (c != null) {
				HttpSession session = request.getSession();
				session.setAttribute("customer", c);
				result[0] = "success";
			} else {
				result[0] = "fail";
				result[1] = "Sai tên đăng nhập hoặc mật khẩu";
			}
		} catch (Exception e) {
			result[0] = "fail";
			result[1] = "Có lỗi xảy ra, thử lại sau";
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
