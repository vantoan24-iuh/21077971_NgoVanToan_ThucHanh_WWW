package vn.edu.iuh.fit.exercise.backend.business;

import vn.edu.iuh.fit.exercise.backend.dots.LoaithuocDto;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Loaithuoc;

import java.util.List;

public interface LoaiThuocRepo {
    List<LoaithuocDto> getALl();
}
