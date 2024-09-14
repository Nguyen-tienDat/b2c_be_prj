package controllers.product;

import database.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Product;

import java.io.IOException;

@WebServlet(name ="DeleteProductServlet", urlPatterns = "/product_delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id  = Integer.parseInt(request.getParameter("id"));

        ProductDAO proDAO = new ProductDAO();
        proDAO.remove(id);

        response.sendRedirect(request.getContextPath()+"/product");
    }

}
