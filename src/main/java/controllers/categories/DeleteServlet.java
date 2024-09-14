package controllers.categories;

import database.CategoriesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteCategoriesServlet", urlPatterns = "/categories_delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //take id from url
        int id = Integer.parseInt(req.getParameter("id"));

        CategoriesDAO catDAO = new CategoriesDAO();
        catDAO.remove(id);

        //send back to categories list
        resp.sendRedirect(req.getContextPath()+"/categories");
    }
}
