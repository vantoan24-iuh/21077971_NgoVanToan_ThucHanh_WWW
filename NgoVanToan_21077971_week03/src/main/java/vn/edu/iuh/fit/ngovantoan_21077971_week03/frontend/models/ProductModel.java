package vn.edu.iuh.fit.ngovantoan_21077971_week03.frontend.models;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.ngovantoan_21077971_week03.backend.repository.entities.Product;

import java.util.List;

public class ProductModel {
    private final String ADD_URL = "http://localhost:8080/NgoVanToan_21077971_week03-1.0-SNAPSHOT/api/products";

    public void createProduct(Product product) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(ADD_URL);

            Response response = target.request().post(Entity.json(product));
            if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                System.out.println("Product added successfully");
            } else {
                System.out.println("Failed to add product");
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(int id) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(ADD_URL).path(String.valueOf(id));
            Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                return response.readEntity(Product.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Product> getAllProducts() {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(ADD_URL);
            Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                return response.readEntity(List.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
