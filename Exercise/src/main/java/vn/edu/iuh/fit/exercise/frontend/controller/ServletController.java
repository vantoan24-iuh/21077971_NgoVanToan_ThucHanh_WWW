package vn.edu.iuh.fit.exercise.frontend.controller;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.exercise.backend.business.ThuocRepo;
import vn.edu.iuh.fit.exercise.backend.dots.ThuocDto;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Loaithuoc;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Thuoc;
import vn.edu.iuh.fit.exercise.frontend.models.ThuocModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletController", value = "/controller")
public class ServletController extends HttpServlet {
    @Inject
    private ThuocModel thuocModel;
    private ThuocRepo thuocRepo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ThuocDto> thuocDtos = thuocModel.getALLThuoc();
        req.setAttribute("thuocs", thuocDtos);
        req.getRequestDispatcher("thuoc.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("add")) {
            String tenThuoc = req.getParameter("tenThuoc");
            String giaThuoc = req.getParameter("giaThuoc");
            String namSX = req.getParameter("namSX");
            String maLoaiThuocParam = req.getParameter("maLoaiThuoc");

            try {
                // Parse the values safely
                double giaThuocValue = Double.parseDouble(giaThuoc.trim());
                int namSXValue = Integer.parseInt(namSX.trim());
                int maLoaiThuocValue = Integer.parseInt(maLoaiThuocParam.trim());

                // Create the Loaithuoc object
                Loaithuoc maLoaiThuoc = new Loaithuoc();
                maLoaiThuoc.setId(maLoaiThuocValue);

                // Create the Thuoc object
                Thuoc thuoc = new Thuoc(tenThuoc.trim(), giaThuocValue, namSXValue, maLoaiThuoc);
                thuocModel.createThuoc(thuoc);

                // Redirect to the index page
                resp.sendRedirect("index.jsp");
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
