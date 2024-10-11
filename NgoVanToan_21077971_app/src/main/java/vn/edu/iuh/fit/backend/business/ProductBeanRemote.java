package vn.edu.iuh.fit.backend.business;

import vn.edu.iuh.fit.backend.repository.entities.Product;
import vn.edu.iuh.fit.backend.repository.entities.ProductPrice;

import java.util.List;

public interface ProductBeanRemote {
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public boolean deleteProduct(Product product);
    public List<Product> getAllProduct();
    public Product getProductById(int id);
}
