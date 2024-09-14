package controllers.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.CartItem;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name ="CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        if (request.getSession().getAttribute(AddToCartServlet.CART_NAME) != null) {
            cartItems = (ArrayList<CartItem>) request.getSession().getAttribute(AddToCartServlet.CART_NAME);
        }
        request.setAttribute("cartItems", cartItems);
        float subTotal = 0.0f;
        for (CartItem item : cartItems) {
            subTotal += item.getProduct().getPrice() * item.getQuantity();
        }
        request.setAttribute("subTotal", subTotal);
        float total = subTotal + subTotal*10/100;
        request.setAttribute("total", total);
        request.getRequestDispatcher("WEB-INF/views/shoppingCart/cart.jsp").forward(request, response);
    }
}
