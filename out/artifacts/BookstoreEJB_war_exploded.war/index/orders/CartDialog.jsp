<%@ page import="entity.orders.Cart" %>
<%@ page import="entity.orders.BookOrder" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.person.CustomerMember" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ken
  Date: 15/03/2016
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/index/orders/Cart.css">
    </head>
    <body>
        <md-toolbar>
            <div class="md-toolbar-tools">
                <img src="/icons/ic_shopping_cart_white_36px.svg" align="center">

                <h3 class="text-color-white">Giỏ hàng</h3>
            </div>
        </md-toolbar>
        <%
            synchronized (session) {
                if (session.getAttribute("cart") != null) {
                    Cart cart = (Cart) session.getAttribute("cart");
                    if (cart == null) {
                        cart = new Cart();
                    }
                    List<BookOrder> arr = cart.getList();
                    int numOfSet = 0;
                    float saleSetBookPrice = 0;
                    String s = "";
                    if (arr.size() > 0) {
        %>
        <form method="post">
            <div class="md-padding">
                <table border="1px" align="left">
                    <tr>
                        <th>Tên sách</th>
                        <th>Ảnh</th>
                        <th>Tác giả</th>
                        <th>Giá gốc</th>
                        <th>Giá bán</th>
                        <th>Số lượng</th>
                        <th>Bộ sách</th>
                        <th>Tổng tiền</th>
                    </tr>
                    <% for (int i = 0; i < arr.size(); i++) {
                        BookOrder bo = arr.get(i);%>
                    <tr>
                        <td><%=bo.getBook().getTitle()%>
                        </td>
                        <td><img src="/imageBook/<%=bo.getBook().getImage()%>"
                                 width="35px" height="60px"/></td>
                        <td><%=bo.getBook().getAuthor().getName()%>
                        </td>
                        <td><%=bo.getBook().getOriginalPrice()%>
                        </td>
                        <td><%=bo.getBook().getSalePrice()%>
                        </td>
                        <td>
                            <%=bo.getQuantity()%>
                            <input type="number" name="quantity" value="<%=bo.getQuantity()%>" hidden>
                        </td>
                        <td><%=bo.getBook().getBookSet().getDescription()%>
                        </td>
                        <td><%=bo.getTotalPrice()%>
                        </td>
                    </tr>
                    <%
                            if (s.indexOf(bo.getBook().getBookSet().getDescription()) != -1) {
                                numOfSet++;
                            } else {
                                s = s + bo.getBook().getBookSet().getDescription();
                            }
                            saleSetBookPrice = cart.getTotalPrice() - numOfSet * 10000;
                        }
                    %>
                    <tr>
                        <td>Pay NOT SALE BOOK SET</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><%=cart.getTotalPrice()%>
                        </td>
                    </tr>
                    <tr>
                        <td>Pay After SALE BOOK SET</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><%=saleSetBookPrice%>
                        </td>
                    </tr>
                    <%

                        }
                    %>
                </table>
            </div>

            <div layout="row" layout-align="center center">
                <a class="md-button md-raised md-accent text-color-white" href="/index/orders/EditCart.jsp">Sửa</a>
                <md-button class="md-raised md-accent text-color-white" ng-click="submitOrder()">Đặt hàng</md-button>
            </div>
        </form>
        <%
        } else {
        %><h3 class="md-padding">Bạn chưa có sách nào trong giỏ!</h3><%
            }
        }%>

    </body>
</html>
