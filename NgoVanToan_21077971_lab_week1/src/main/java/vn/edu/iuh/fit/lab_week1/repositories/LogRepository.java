package vn.edu.iuh.fit.lab_week1.repositories;

import vn.edu.iuh.fit.lab_week1.entities.Log;

import java.util.List;

public interface LogRepository {
    public List<Log> findAll();
    public Log findById(String id);
    public boolean exists(String id);
    public void save(Log log);
    public Log update(Log log);
    public boolean delete(Log log);
}
