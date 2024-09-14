package controllers.categories;

import database.CategoriesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Categories;

import java.io.IOException;

@WebServlet(name ="UpdateCategoriesServlet", urlPatterns = "/categories_edit")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CategoriesDAO catDAO = new CategoriesDAO();
        Categories cat = catDAO.get(id);
        request.setAttribute("cat", cat);
        request.getRequestDispatcher("/WEB-INF/views/categories/update.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        CategoriesDAO catDAO = new CategoriesDAO();
        Categories cat = new Categories();
        cat.setName(name);
        cat.setId(id);
        catDAO.update(id, cat);
        response.sendRedirect(request.getContextPath() + "/categories");

    }
}
