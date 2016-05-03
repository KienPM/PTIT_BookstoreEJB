package servlet.orders;

import entity.orders.AddressShipping;
import entity.orders.ShippingInfor;
import entity.person.Customer;
import sessionbean.orders.ShippingInforSessionBeanRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SetShippingInfo")
public class SetShippingInfo extends HttpServlet {
    @EJB
    ShippingInforSessionBeanRemote shippingInforSessionBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        String ward = request.getParameter("ward");
        String district = request.getParameter("district");
        String city = request.getParameter("city");
        AddressShipping addressShipping = new AddressShipping(num, ward, district, city);
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        ShippingInfor shippingInfor = new ShippingInfor(customer, addressShipping);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
