package vn.edu.iuh.fit.exercise.backend.api;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.exercise.backend.business.ThuocRepo;
import vn.edu.iuh.fit.exercise.backend.business.imp.ThuocRepoImp;
import vn.edu.iuh.fit.exercise.backend.dots.ThuocDto;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Thuoc;

@Path("/thuoc")
public class ThuocResoure {
    @EJB
    private ThuocRepo thuocRepoImp;

    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(thuocRepoImp.getAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(thuocRepoImp.getAllByLoaiThuoc(id)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Thuoc thuoc) {
        thuocRepoImp.add(thuoc);
        return Response.ok(thuoc).build();
    }
}
