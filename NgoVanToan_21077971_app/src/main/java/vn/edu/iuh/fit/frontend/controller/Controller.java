package vn.edu.iuh.fit.frontend.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.repository.entities.Product;
import vn.edu.iuh.fit.frontend.models.ProductModel;

import java.io.IOException;

@WebServlet(name="controller", value = "/controller")
public class Controller extends HttpServlet {
    @Inject
    private ProductModel productModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("add")){
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String imgPath = req.getParameter("imgPath");

            Product product = new Product(name, description, imgPath);
            productModel.createProduct(product);
            resp.sendRedirect("formProduct.jsp");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
