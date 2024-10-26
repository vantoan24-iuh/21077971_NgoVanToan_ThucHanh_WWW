package vn.edu.iuh.fit.exercise_xe.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.exercise_xe.Dtos.HangxeDto;
import vn.edu.iuh.fit.exercise_xe.Dtos.XeDto;
import vn.edu.iuh.fit.exercise_xe.entities.Xe;
import vn.edu.iuh.fit.exercise_xe.services.HangXeService;
import vn.edu.iuh.fit.exercise_xe.services.XeService;

@WebServlet(name = "ServletController", value = "/controller")
public class HelloServlet extends HttpServlet {
    @EJB
    private XeService xeService = new XeService();

    @EJB
    private HangXeService hangXeService = new HangXeService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession(true);

        if (action!=null && action.equalsIgnoreCase("dsXe")) {
            List<XeDto> listXe = xeService.getAllXe();
            session.setAttribute("listXe", listXe);
            request.getRequestDispatcher("index.jsp").forward(request, response); // Use forward instead of redirect

        } else if (action.equalsIgnoreCase("search")) {
            String searchInput = request.getParameter("search");
            List<XeDto> searchResults = new ArrayList<>();
            try {
                double price = Double.parseDouble(searchInput);
                XeDto xe = xeService.getByGiaXe(price);
                if (xe != null) {
                    searchResults.add(xe);
                }
            } catch (NumberFormatException e) {
                XeDto xe = xeService.getByTenXe(searchInput);
                if (xe != null) {
                    searchResults.add(xe);
                }
            }
            session.setAttribute("listXe", searchResults);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("add")) {
            Xe xe = new Xe();
            xe.setTenXe(req.getParameter("tenXe"));
            xe.setGiaXe(Double.parseDouble(req.getParameter("giaXe")));
            xe.setNamSX(Integer.parseInt(req.getParameter("namSX")));

            String hangXeId = req.getParameter("hangXe");
            HangxeDto hangxe = hangXeService.getById(Integer.parseInt(hangXeId));

            xeService.save(new XeDto(xe.getTenXe(), xe.getGiaXe(), xe.getNamSX(), hangxe)); // Adjusted to use Hangxe

            resp.sendRedirect("index.jsp");
        }
    }
}
