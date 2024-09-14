package controllers.categories;

import database.CategoriesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Categories;

import java.io.IOException;

@WebServlet(name="CategoriesAddServlet", urlPatterns = "/categories_add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/categories/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        CategoriesDAO catDAO = new CategoriesDAO();
        Categories cat = new Categories();
        cat.setName(name);
        catDAO.add(cat);
        resp.sendRedirect(req.getContextPath()+"/categories");
    }
}
