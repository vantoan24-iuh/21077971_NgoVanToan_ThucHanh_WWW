package vn.edu.iuh.fit.ngovantoan_21077971_week03.frontend.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.ngovantoan_21077971_week03.backend.repository.entities.Product;
import vn.edu.iuh.fit.ngovantoan_21077971_week03.frontend.models.ProductModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name="Controller", value = "/controller")
public class Controller extends HttpServlet {
    @Inject
    private ProductModel productModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null){
            int productId = Integer.parseInt(req.getParameter("id"));
            Product product = productModel.getProductById(productId);
            if(product == null){
                req.setAttribute("error", "Khong tim thay");
            }
            List<Product> products = productModel.getAllProducts();
            req.setAttribute("products", products);
            req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
}
