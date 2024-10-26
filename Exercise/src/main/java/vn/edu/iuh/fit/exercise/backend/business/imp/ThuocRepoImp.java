package vn.edu.iuh.fit.exercise.backend.business.imp;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.exercise.backend.business.ThuocRepo;
import vn.edu.iuh.fit.exercise.backend.dots.LoaithuocDto;
import vn.edu.iuh.fit.exercise.backend.dots.ThuocDto;
import vn.edu.iuh.fit.exercise.backend.repositories.LoaiThuocRepository;
import vn.edu.iuh.fit.exercise.backend.repositories.ThuocRepository;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Thuoc;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ThuocRepoImp implements ThuocRepo {
    @Inject
    private ThuocRepository thuocRepository;
    @Inject
    private LoaiThuocRepository loaiThuocRepository;


    @Override
    public List<ThuocDto> getAll() {
        List<Thuoc> thuocs = thuocRepository.getAll();
        List<ThuocDto> thuocDtos = new ArrayList<>();
        for (Thuoc thuoc : thuocs) {
            LoaithuocDto loaithuocDto = new LoaithuocDto(
                    thuoc.getMaLoai().getId(),
                    thuoc.getMaLoai().getTenLoai()
            );
            ThuocDto thuocDto = new ThuocDto(
                    thuoc.getId(),
                    thuoc.getTenThuoc(),
                    thuoc.getGia(),
                    thuoc.getNamSX(),
                    loaithuocDto
            );
            thuocDtos.add(thuocDto);
        }
        return thuocDtos;
    }

    @Override
    public List<ThuocDto> getAllByLoaiThuoc(int id) {
        List<Thuoc> thuocs = thuocRepository.getAllByLoaiThuoc(id);
        List<ThuocDto> thuocDtos = new ArrayList<>();
        for (Thuoc thuoc : thuocs) {
            LoaithuocDto loaithuocDto = new LoaithuocDto(
                    thuoc.getMaLoai().getId(),
                    thuoc.getMaLoai().getTenLoai()
            );
            ThuocDto thuocDto = new ThuocDto(
                    thuoc.getId(),
                    thuoc.getTenThuoc(),
                    thuoc.getGia(),
                    thuoc.getNamSX(),
                    loaithuocDto
            );
            thuocDtos.add(thuocDto);
        }
        return thuocDtos;
    }

    @Override
    public void add(Thuoc thuoc) {
        thuocRepository.add(thuoc);
    }

}

