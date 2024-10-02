package vn.edu.iuh.fit.lab_week1.repositories;

import vn.edu.iuh.fit.lab_week1.entities.Role;

import java.util.List;

public interface RoleRepository {
    public List<Role> findAll();
    public Role findById(String id);
    public boolean exists(String id);
    public void save(Role role);
    public Role update(Role role);
    public boolean delete(Role role);
    public boolean isAdministrator(String accountId);
}
