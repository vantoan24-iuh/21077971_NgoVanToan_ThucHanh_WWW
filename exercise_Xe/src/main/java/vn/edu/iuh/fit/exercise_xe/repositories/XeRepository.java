package vn.edu.iuh.fit.exercise_xe.repositories;

import vn.edu.iuh.fit.exercise_xe.Dtos.XeDto;

import java.util.List;

public interface XeRepository {
    List<XeDto> getAllXe();
    XeDto getByTenXe(String tenXe);
    XeDto getByGiaXe(Double giaXe);
    boolean save(XeDto xeDto);
    XeDto getById(int id);
}
