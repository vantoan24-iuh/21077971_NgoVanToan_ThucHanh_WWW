package vn.edu.iuh.fit.exercise_xe.services;

import vn.edu.iuh.fit.exercise_xe.Dtos.XeDto;
import vn.edu.iuh.fit.exercise_xe.entities.Xe;
import vn.edu.iuh.fit.exercise_xe.repositories.HangXeRepository;
import vn.edu.iuh.fit.exercise_xe.repositories.XeRepository;
import vn.edu.iuh.fit.exercise_xe.repositories.imp.HangXeRepositoryImp;
import vn.edu.iuh.fit.exercise_xe.repositories.imp.XeRepositoryImp;

import java.util.List;

public class XeService {
    private XeRepository xeRepositoryImp;
    private HangXeRepository hangXeRepositoryImp;

    public XeService() {
        xeRepositoryImp = new XeRepositoryImp();
        hangXeRepositoryImp = new HangXeRepositoryImp();
    }

    public List<XeDto> getAllXe() {
        return xeRepositoryImp.getAllXe();
    }

    public XeDto getByTenXe(String tenXe) {
        return xeRepositoryImp.getByTenXe(tenXe);
    }

    public XeDto getByGiaXe(Double giaXe) {
        return xeRepositoryImp.getByGiaXe(giaXe);
    }

    public boolean save(XeDto xeDto) {
        return xeRepositoryImp.save(xeDto);
    }
}
