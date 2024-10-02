package vn.edu.iuh.fit.backend.api;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.backend.repository.entities.Product;

@Path("/product")
public class ProductResource {
    @EJB
    private ProductBeanRemote productBeanRemote;

    @GET
    public Response getAllProduct() {
        return Response.ok(productBeanRemote.getAllProduct()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(int id) {
        return Response.ok(productBeanRemote.getProductById(id)).build();
    }

    @POST
    @Consumes()
    public Response createProduct(Product product) {
        productBeanRemote.addProduct(product);
        return Response.ok(product).build();
    }
}
