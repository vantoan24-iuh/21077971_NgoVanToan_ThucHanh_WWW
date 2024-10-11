package vn.edu.iuh.fit.backend.business.Imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.backend.repository.entities.Product;

import java.util.List;

public class ProductImp implements ProductBeanRemote {
    @PersistenceContext(unitName = "mariadb")
    private EntityManager entityManager;

    public ProductImp() {
//        entityManager = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.merge(product);

    }

    @Override
    public boolean deleteProduct(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAllProduct() {

        return entityManager.createNamedQuery("Product.findAll",Product.class).getResultList();
    }
    @Override
    public Product getProductById(int id) {
        return entityManager.find(Product.class, id);
    }
}
