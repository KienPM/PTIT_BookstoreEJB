package servlet.orders;

import com.google.gson.Gson;
import entity.book.Book;
import entity.orders.BookOrder;
import entity.orders.Cart;
import sessionbean.book.BookSessionBeanRemote;
import sessionbean.orders.BookOrderSessionBeanRemote;
import sessionbean.orders.CartSessionBeanRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {

    @EJB
    CartSessionBeanRemote cartSessionBean;
    @EJB
    BookSessionBeanRemote bookSessionBean;
    @EJB
    BookOrderSessionBeanRemote bookOrderSessionBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object[] result = new Object[1];
        synchronized (session) {
            Cart cart = (Cart) session.getAttribute("cart");
            String bookID = request.getParameter("idbook").trim();
            Book book = null;
            try {
                book = bookSessionBean.findByID(Integer.parseInt(bookID));
                if (cart == null) {
                    int cartID = cartSessionBean.create();
                    cart = new Cart(cartID, new ArrayList<>());
                }
                BookOrder bo = new BookOrder(book, 1, cart);
                int bookOrderID = bookOrderSessionBean.saveBookOrder(bo);
                bo.setId(bookOrderID);
                cart.addToCart(bo);
                result[0] = "success";
            } catch (Exception e) {
                result[0] = "fail";
                e.printStackTrace();
            } finally {
                session.setAttribute("cart", cart);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(new Gson().toJson(result));
            }
        }
    }
}