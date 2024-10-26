package vn.edu.iuh.fit.exercise.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Loaithuoc;

import java.util.List;

public class LoaiThuocRepository {
    @PersistenceContext(unitName = "mariadb")
    private EntityManager entityManager;

    public LoaiThuocRepository() {
    }

    public List<Loaithuoc> getALl() {
        return entityManager.createNamedQuery("Loaithuoc.findAll", Loaithuoc.class).getResultList();
    }
    public Loaithuoc findById(int id){
        return entityManager.find(Loaithuoc.class,id);
    }

}
