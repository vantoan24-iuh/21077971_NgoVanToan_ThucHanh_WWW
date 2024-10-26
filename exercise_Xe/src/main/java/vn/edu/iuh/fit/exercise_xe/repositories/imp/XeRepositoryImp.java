package vn.edu.iuh.fit.exercise_xe.repositories.imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.exercise_xe.Dtos.HangxeDto;
import vn.edu.iuh.fit.exercise_xe.Dtos.XeDto;
import vn.edu.iuh.fit.exercise_xe.entities.Hangxe;
import vn.edu.iuh.fit.exercise_xe.entities.Xe;
import vn.edu.iuh.fit.exercise_xe.repositories.HangXeRepository;
import vn.edu.iuh.fit.exercise_xe.repositories.XeRepository;

import java.util.ArrayList;
import java.util.List;

public class XeRepositoryImp implements XeRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private HangXeRepository hangXeRepository;

    public XeRepositoryImp() {
        entityManager = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
        transaction = entityManager.getTransaction();
        hangXeRepository = new HangXeRepositoryImp();
    }

    @Override
    public List<XeDto> getAllXe() {
        List<Xe> xeList = entityManager.createNamedQuery("Xe.findAllXe", Xe.class).getResultList();
        List<XeDto> xeDtos = new ArrayList<>();
        for (Xe xe : xeList) {
            HangxeDto maHangXe = hangXeRepository.getById(xe.getMaHangXe().getId());
            xeDtos.add(new XeDto(xe.getId(), xe.getTenXe(), xe.getGiaXe(), xe.getNamSX(), maHangXe));
        }
        return xeDtos;
    }

    @Override
    public XeDto getByTenXe(String tenXe) {
        Xe xe = entityManager.createNamedQuery("Xe.findByTenXe", Xe.class).setParameter("tenXe", tenXe).getSingleResult();
        HangxeDto maHangXe = hangXeRepository.getById(xe.getMaHangXe().getId());
        return new XeDto(xe.getId(), xe.getTenXe(), xe.getGiaXe(), xe.getNamSX(), maHangXe);
    }

    @Override
    public XeDto getByGiaXe(Double giaXe) {
        Xe xe = entityManager.createNamedQuery("Xe.findByGiaXe", Xe.class).setParameter("giaXe", giaXe).getSingleResult();
        HangxeDto maHangXe = hangXeRepository.getById(xe.getMaHangXe().getId());
        return new XeDto(xe.getId(), xe.getTenXe(), xe.getGiaXe(), xe.getNamSX(), maHangXe);
    }

    @Override
    public boolean save(XeDto xeDto) {
        try {
            Xe xe = new Xe();
            xe.setTenXe(xeDto.getTenXe());
            xe.setGiaXe(xeDto.getGiaXe());
            xe.setNamSX(xeDto.getNamSX());
            Hangxe hangxe = entityManager.find(Hangxe.class, xeDto.getMaHangXe().getId());
            xe.setMaHangXe(hangxe);
            transaction.begin();
            entityManager.persist(xe);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public XeDto getById(int id) {
        Xe xe = entityManager.find(Xe.class, id);
        return new XeDto(xe.getId(), xe.getTenXe(), xe.getGiaXe(), xe.getNamSX(), hangXeRepository.getById(xe.getMaHangXe().getId()));
    }

    public static void main(String[] args) {
        XeRepository xeRepositoryImp = new XeRepositoryImp();
        List<XeDto> xeDtos = xeRepositoryImp.getAllXe();
        XeDto xeDto = xeRepositoryImp.getByTenXe("Sirius");
        System.out.println("Xe theo tên");
        System.out.println(xeDto);

        System.out.println("===================================");
        System.out.println("Xe theo giá");
        XeDto xeDto1 = xeRepositoryImp.getByGiaXe(15550000.0);
        System.out.println(xeDto1);

        System.out.println("===================================");
        System.out.println("Danh sách xe");
        for (XeDto xe : xeDtos) {
            System.out.println(xe);
        }

        System.out.println("===================================");
        System.out.println("Thêm xe");
        XeDto xeDto2 = new XeDto("Exciter", 45000000.0, 2021, new HangxeDto(1, "Yamaha", "Nhật Bản", "Xe máy"));
        xeRepositoryImp.save(xeDto2);

        System.out.println("===================================");
        System.out.println("Danh sách xe Sau Them");
        for (XeDto xe : xeDtos) {
            System.out.println(xe);
        }

    }
}
