package vn.edu.iuh.fit.lab_week1.repositories.imp;

import vn.edu.iuh.fit.lab_week1.entities.Log;
import vn.edu.iuh.fit.lab_week1.repositories.LogRepository;

import java.util.List;

public class LogRepositoryImp implements LogRepository {
    @Override
    public List<Log> findAll() {
        return List.of();
    }

    @Override
    public Log findById(String id) {
        return null;
    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public void save(Log log) {

    }

    @Override
    public Log update(Log log) {
        return null;
    }

    @Override
    public boolean delete(Log log) {
        return false;
    }
}
