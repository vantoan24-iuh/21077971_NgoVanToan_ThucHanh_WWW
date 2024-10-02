package vn.edu.iuh.fit.backend.business;

import vn.edu.iuh.fit.backend.repository.entities.Product;

import java.util.List;

public interface ProductBeanRemote {
    public boolean addProduct(Product product);
    public Product updateProduct();
    public boolean deleteProduct();
    public List<Product> getAllProduct();
    public Product getProductById(int id);
}
