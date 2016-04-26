package servlet.orders;

import com.google.gson.Gson;
import entity.orders.BookOrder;
import entity.orders.Cart;
import entity.person.CustomerMember;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ken on 29/03/2016.
 */
@WebServlet(name = "SaveCart", urlPatterns = "/SaveCart")
public class SaveCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object[] result = new Object[2];
//        HttpSession session = request.getSession();
//        if (session.getAttribute("cart") != null && session.getAttribute("customer") != null) {
//            Cart cart = (Cart) session.getAttribute("cart");
//            List<BookOrder> list = cart.getList();
//            String[] quantities = request.getParameterValues("quantities");
//            for (int i = 0; i < quantities.length; ++i) {
//                list.get(i).setQuantity(Integer.parseInt(quantities[i]));
//            }
//            CustomerMember customerMember = (CustomerMember) session.getAttribute("customer");
//            CartDAO cartDAO = new CartDAO();
//            try {
//                cartDAO.saveCart(cart.getId(), customerMember.getId());
//                result[0] = "success";
//            } catch (Exception e) {
//                result[0] = "fail";
//                result[1] = "Có lỗi xảy ra, vui lòng thử lại sau!";
//                e.printStackTrace();
//            }
//        } else {
//            result[0] = "fail";
//            result[1] = "Chưa đăng nhập";
//        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
