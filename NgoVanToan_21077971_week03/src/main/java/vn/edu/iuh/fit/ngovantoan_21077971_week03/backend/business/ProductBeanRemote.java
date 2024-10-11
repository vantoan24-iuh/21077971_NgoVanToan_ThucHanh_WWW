package vn.edu.iuh.fit.ngovantoan_21077971_week03.backend.business;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import vn.edu.iuh.fit.ngovantoan_21077971_week03.backend.repository.entities.Product;

import java.util.List;

@Remote
public interface ProductBeanRemote {
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public boolean deleteProduct(Product product);
    public List<Product> getAllProduct();
    public Object getProductById(int id);
}
