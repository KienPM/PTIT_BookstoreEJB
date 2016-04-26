package servlet.orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.orders.BookOrder;
import entity.orders.Cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
//        synchronized (session) {
//            Cart cart = (Cart) session.getAttribute("cart");
//            if (cart != null) {
//                List<BookOrder> list = cart.getList();
//                String[] quantities = request.getParameterValues("quantities");
//                for (int i = 0; i < quantities.length; ++i) {
//                    list.get(i).setQuantity(Integer.parseInt(quantities[i]));
//                }
//            }
//        }
//        response.sendRedirect("/index/orders/EditCart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
