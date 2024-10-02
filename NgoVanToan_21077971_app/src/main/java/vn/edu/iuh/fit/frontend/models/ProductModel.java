package vn.edu.iuh.fit.frontend.models;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.repository.entities.Product;

public class ProductModel {
    private final String ADD_URL="/api/products";
    public void createProduct(Product product) {
        try(Client client= ClientBuilder.newClient()) {
            WebTarget ws=client.target(ADD_URL);
            Response response=ws.request(MediaType.APPLICATION_JSON).post(Entity.entity(product, MediaType.APPLICATION_JSON));

            if(response.getStatus()==Response.Status.CREATED.getStatusCode()){
                System.out.println("Product created");
            }else {
                System.out.println("Product not created");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
