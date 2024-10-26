package vn.edu.iuh.fit.exercise.backend.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.exercise.backend.business.LoaiThuocRepo;

@Path("/loaithuoc")
public class LoaiThuocResoure {
    @Inject
    private LoaiThuocRepo loaiThuocRepo;

    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(loaiThuocRepo.getALl()).build();
    }
}
