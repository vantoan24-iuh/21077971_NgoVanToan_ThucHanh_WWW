package vn.edu.iuh.fit.exercise.backend.business.imp;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.exercise.backend.business.LoaiThuocRepo;
import vn.edu.iuh.fit.exercise.backend.repositories.LoaiThuocRepository;
import vn.edu.iuh.fit.exercise.backend.dots.LoaithuocDto;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Loaithuoc;

import java.util.List;
import java.util.ArrayList;

@Stateless
public class LoaiThuocRepoImp implements LoaiThuocRepo {
    @Inject
    private LoaiThuocRepository loaiThuocRepository;

    @Override
    public List<LoaithuocDto> getALl() {
        List<Loaithuoc> loaithuocs = loaiThuocRepository.getALl();
        List<LoaithuocDto> loaithuocDtos = new ArrayList<>();
        for (Loaithuoc loaithuoc : loaithuocs) {
            LoaithuocDto loaithuocDto = new LoaithuocDto(
                    loaithuoc.getId(),
                    loaithuoc.getTenLoai());
            loaithuocDtos.add(loaithuocDto);
        }
        return loaithuocDtos;
    }
}


