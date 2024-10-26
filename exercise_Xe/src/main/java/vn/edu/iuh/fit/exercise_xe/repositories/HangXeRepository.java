package vn.edu.iuh.fit.exercise_xe.repositories;

import vn.edu.iuh.fit.exercise_xe.Dtos.HangxeDto;

import java.util.List;

public interface HangXeRepository {
    List<HangxeDto> getAll();
    HangxeDto getById(int id);
    boolean save(HangxeDto hangxeDto);
    boolean update(HangxeDto hangxeDto);
}
