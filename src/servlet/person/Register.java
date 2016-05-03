package servlet.person;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.bank.KcoinBank;
import entity.book.Book;
import entity.person.*;
import sessionbean.person.CustomerMemberSessionBeanRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
    @EJB
    CustomerMemberSessionBeanRemote customerMemberSessionBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        JsonObject user = (JsonObject) new JsonParser().parse(request.getParameter("user"));

        String nationality = user.get("nationality").getAsString();
        System.out.println(nationality);
        PersonBuilder personBuilder;
        if (nationality.equalsIgnoreCase("Việt Nam")) {
            personBuilder = new VietnamesePersonBuilder();
//            System.out.println("nationality vn");
        } else {
            personBuilder = new OtherCountryPersonBuilder();
//            System.out.println("nationality other");
        }
        personBuilder.buildAddress(user.get("address").getAsString());
        personBuilder.buildFullName(user.get("name").getAsString());

        CustomerMember customerMember = new CustomerMember(personBuilder.getPerson());
        customerMember.setUsername(user.get("username").getAsString());
        customerMember.setPassword(user.get("password").getAsString());
        customerMember.setPhoneNum(user.get("phone").getAsString());
        customerMember.setEmail(user.get("email").getAsString());
        customerMember.setKcoinBank(new KcoinBank(100, "kcoin"));
        Object[] result = new Object[2];
        try {
            int id = customerMemberSessionBean.save(customerMember);
            customerMember.setId(id);
            HttpSession session = request.getSession();
            session.setAttribute("customer", customerMember);
            result[0] = "success";
        } catch (Exception e) {
            e.printStackTrace();
            result[0] = "fail";
            result[1] = "Có lỗi xảy ra, vui lòng thử lại sau";
        } finally {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(result));
        }
    }
}
