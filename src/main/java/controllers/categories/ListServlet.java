package controllers.categories;

import database.CategoriesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Categories;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListCategoriesServlet", urlPatterns = "/categories")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //create an instance catDAO to work with database
        //retrieve a list of cat from db and stored in cat Obj
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        ArrayList<Categories> categories = categoriesDAO.list();

        //set data into request to show in views
        req.setAttribute("categories", categories);
        for (Categories category : categories) {
            System.out.println("categories" + category.getName());
        }

        //upload the jsp file
        req.getRequestDispatcher("/WEB-INF/views/categories/list.jsp").forward(req, resp);
    }
}
