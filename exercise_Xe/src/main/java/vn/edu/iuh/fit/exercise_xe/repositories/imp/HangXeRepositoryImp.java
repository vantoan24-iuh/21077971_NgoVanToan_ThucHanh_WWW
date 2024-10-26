package vn.edu.iuh.fit.exercise_xe.repositories.imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.exercise_xe.Dtos.HangxeDto;
import vn.edu.iuh.fit.exercise_xe.entities.Hangxe;
import vn.edu.iuh.fit.exercise_xe.repositories.HangXeRepository;

import java.util.List;

public class HangXeRepositoryImp implements HangXeRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public HangXeRepositoryImp() {
        entityManager = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public List<HangxeDto> getAll() {
        return List.of();
    }

    @Override
    public HangxeDto getById(int id) {
        Hangxe hangxe = entityManager.find(Hangxe.class, id);
        return new HangxeDto(hangxe.getId(), hangxe.getTenHang(), hangxe.getQuocGia(), hangxe.getMoTa());
    }

    @Override
    public boolean save(HangxeDto hangxeDto) {
        return false;
    }

    @Override
    public boolean update(HangxeDto hangxeDto) {
        return false;
    }
}
