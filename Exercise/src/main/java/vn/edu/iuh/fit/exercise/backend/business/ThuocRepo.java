package vn.edu.iuh.fit.exercise.backend.business;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import vn.edu.iuh.fit.exercise.backend.dots.ThuocDto;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Thuoc;

import java.util.List;

@Local
public interface ThuocRepo {
    List<ThuocDto> getAll();
    List<ThuocDto> getAllByLoaiThuoc(int id);
    void add(Thuoc thuoc);
}
