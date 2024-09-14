package controllers.product;

import database.CategoriesDAO;
import database.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Categories;
import models.Product;

import java.io.IOException;

@WebServlet(name ="UpdateProductServlet", urlPatterns = "/product_edit")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        Product product  = productDAO.get(id);
        request.setAttribute("product", product);

        CategoriesDAO categoriesDAO = new CategoriesDAO();
        request.setAttribute("categories", categoriesDAO.list());

        request.getRequestDispatcher("/WEB-INF/views/product/update.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String categoryId = request.getParameter("categoryId");
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();

        product.setName(name);
        product.setId(id);
        product.setPrice(Double.parseDouble(price));
        product.setCategoryId(Integer.parseInt(categoryId));

        productDAO.update(id, product);
        response.sendRedirect(request.getContextPath() + "/product");

    }
}
