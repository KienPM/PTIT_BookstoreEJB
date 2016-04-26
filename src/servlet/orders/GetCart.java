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
 * Created by Ken on 12/04/2016.
 */
@WebServlet(name = "GetCart", urlPatterns = "/GetCart")
public class GetCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object[] result = new Object[2];
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            result[0] = "success";
            result[1] = cart;
        } else {
            result[0] = "fail";
            result[1] = "Có lỗi xảy ra, vui lòng thử lại sau!";
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
