package vn.edu.iuh.fit.lab_week1.repositories.imp;

import vn.edu.iuh.fit.lab_week1.entities.Role;
import vn.edu.iuh.fit.lab_week1.repositories.RoleRepository;

import java.util.List;

public class RoleRepositoryImp implements RoleRepository {
    @Override
    public List<Role> findAll() {
        return List.of();
    }

    @Override
    public Role findById(String id) {
        return null;
    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public boolean delete(Role role) {
        return false;
    }

    @Override
    public boolean isAdministrator(String accountId) {
        return false;
    }
}
