package controllers.cart;

import database.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.CartItem;
import models.Product;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddToCart", urlPatterns = "/cart_add")
public class AddToCartServlet extends HttpServlet {
    public static final String CART_NAME  = "cart";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        // get product based on id
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.get(id);

        //get cart from session
        ArrayList< CartItem> cart = new ArrayList<>();
        if(request.getSession().getAttribute(CART_NAME) != null) {
            cart = (ArrayList<CartItem>) request.getSession().getAttribute(CART_NAME);

            //check if the product are in the cart
            for(CartItem cartItem : cart) {
                if(cartItem.getProduct().getId() == product.getId()) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);

                    //check done, resave cart into session
                    request.getSession().setAttribute(CART_NAME, cart);
                    response.sendRedirect(request.getContextPath() + "/cart");
                    return;
                }
            }
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cart.add(cartItem);

            //save cart into session
            request.getSession().setAttribute(CART_NAME, cart);
            response.sendRedirect(request.getContextPath() + "/cart");
        }
    }
}
