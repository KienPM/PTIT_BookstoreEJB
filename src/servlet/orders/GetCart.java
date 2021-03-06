package servlet.orders;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

/**
 * Created by Ken on 12/04/2016.
 */
@WebServlet(name = "GetCart", urlPatterns = "/GetCart")
public class GetCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object[] result = new Object[2];
        HttpSession session = request.getSession();
        Gson gson = new Gson();
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            result[0] = "success";
            ArrayList<BookOrder> list = new ArrayList<>();
            for (BookOrder bookOrder : cart.getList()) {
                list.add(new BookOrder(bookOrder.getId(), bookOrder.getBook(), bookOrder.getQuantity()));
            }
            result[1] = list;
        } else {
            result[0] = "fail";
            result[1] = "Có lỗi xảy ra, vui lòng thử lại sau!";
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
