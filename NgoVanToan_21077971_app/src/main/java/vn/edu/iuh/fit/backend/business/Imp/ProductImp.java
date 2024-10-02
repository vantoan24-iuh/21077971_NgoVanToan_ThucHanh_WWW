package vn.edu.iuh.fit.backend.business.Imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.backend.repository.entities.Product;

import java.util.List;

public class ProductImp implements ProductBeanRemote {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    private Product product;

    public ProductImp() {
        entityManager = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
        entityTransaction = entityManager.getTransaction();
        product = new Product();
    }
    @Override
    public boolean addProduct(Product product) {
        try {
            entityTransaction.begin();
            entityManager.persist(product);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product updateProduct() {
        try {
            entityTransaction.begin();
            int update=entityManager.createNamedQuery("Product.updateById")
                    .setParameter("name",product.getName())
                    .setParameter("description",product.getDescription())
                    .setParameter("imgPath",product.getImgPath())
                    .setParameter("id",product.getId())
                    .executeUpdate();
            entityTransaction.commit();

            if(update>0){
                return entityManager.find(Product.class,product.getId());
            }else {
                return null;
            }
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteProduct() {
        try {
            entityTransaction.begin();
            int delete=entityManager.createNamedQuery("Product.deleteById")
                    .setParameter("id",product.getId())
                    .executeUpdate();
            entityTransaction.commit();

            if(delete>0){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAllProduct() {

            return entityManager.createNamedQuery("Product.findAll").getResultList();
    }
    @Override
    public Product getProductById(int id){
        return entityManager.find(Product.class,id);
    }
}
