package vn.edu.iuh.fit.exercise_xe.services;

import vn.edu.iuh.fit.exercise_xe.Dtos.HangxeDto;
import vn.edu.iuh.fit.exercise_xe.repositories.HangXeRepository;
import vn.edu.iuh.fit.exercise_xe.repositories.imp.HangXeRepositoryImp;

public class HangXeService {
    private HangXeRepository hangXeRepositoryImp;

    public HangXeService() {
        hangXeRepositoryImp = new HangXeRepositoryImp();
    }

    public HangxeDto getById(int id) {
        return hangXeRepositoryImp.getById(id);
    }

}
