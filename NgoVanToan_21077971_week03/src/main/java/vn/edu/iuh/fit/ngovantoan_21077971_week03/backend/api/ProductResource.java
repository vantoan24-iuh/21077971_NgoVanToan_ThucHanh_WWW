package vn.edu.iuh.fit.ngovantoan_21077971_week03.backend.api;

import jakarta.ejb.EJB;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.ngovantoan_21077971_week03.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.ngovantoan_21077971_week03.backend.repository.entities.Product;

@Path("/products")
public class ProductResource {
    @EJB
    private ProductBeanRemote productBeanRemote;

    @Produces("application/json")
    @GET
    public Response getAllProduct() {
        return Response.ok(productBeanRemote.getAllProduct()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(productBeanRemote.getProductById(id)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public Response createProduct(Product product) {
        productBeanRemote.addProduct(product);
        return Response.ok(product).build();
    }
}
