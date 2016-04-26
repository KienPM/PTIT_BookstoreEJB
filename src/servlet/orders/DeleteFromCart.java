package servlet.orders;

import com.google.gson.Gson;
import entity.book.Book;
import entity.orders.BookOrder;
import entity.orders.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookOrderID = Integer.parseInt(request.getParameter("bookorderid"));
//        System.out.println("del " + bookOrderID);
        HttpSession session = request.getSession();
//        synchronized (session) {
//            if (session.getAttribute("cart") != null) {
//                Cart cart = (Cart) session.getAttribute("cart");
//                ArrayList<BookOrder> list = cart.getList();
//                try {
//                    BookOrderDAO bookOrderDAO = new BookOrderDAO();
//                    bookOrderDAO.deleteBookOrder(bookOrderID);
//                    for (BookOrder bo : list) {
//                        if (bo.getId() == bookOrderID) {
//                            list.remove(bo);
//                            break;
//                        }
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    session.setAttribute("cart", cart);
//                }
//            }
//        }
        response.sendRedirect("/index/orders/EditCart.jsp");
    }
}
