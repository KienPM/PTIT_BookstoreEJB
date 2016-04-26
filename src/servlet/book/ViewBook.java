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
import java.util.List;

@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
    @EJB
    BookSessionBeanRemote bookSessionBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookID = Integer.parseInt(request.getParameter("idbook"));
        Object[] result = new Object[2];
        try {
            Book book = bookSessionBean.findByID(bookID);
            result[0] = "success";
            result[1] = book;
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
