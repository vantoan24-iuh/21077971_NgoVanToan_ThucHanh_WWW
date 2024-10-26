package vn.edu.iuh.fit.exercise.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Thuoc;

import java.util.List;

public class ThuocRepository {
    @PersistenceContext(unitName = "mariadb")
    private EntityManager entityManager;
    public ThuocRepository() {
    }

    public List<Thuoc> getAll() {
        return entityManager.createNamedQuery("Thuoc.findALl", Thuoc.class).getResultList();
    }
    public Thuoc findById(int id){
        return entityManager.find(Thuoc.class,id);
    }

    public List<Thuoc> getAllByLoaiThuoc(int id){
        return entityManager.createNamedQuery("Loaithuoc.findThuocByLoaiThuoc", Thuoc.class).setParameter("id", id).getResultList();
    }
    public void add(Thuoc thuoc){
        entityManager.persist(thuoc);
    }
}
