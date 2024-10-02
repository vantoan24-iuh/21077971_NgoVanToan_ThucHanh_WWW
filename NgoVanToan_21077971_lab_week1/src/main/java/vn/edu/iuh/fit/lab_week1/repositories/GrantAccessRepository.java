package vn.edu.iuh.fit.lab_week1.repositories;

import vn.edu.iuh.fit.lab_week1.entities.GrantAccess;

import java.util.List;

public interface GrantAccessRepository {
    public List<GrantAccess> findAccountByRoleId(String roleId);
    public List<GrantAccess> findRoleByAccountId(String accountId);
    public boolean save(GrantAccess grantAccess);
    public boolean delete(GrantAccess grantAccess);
    public boolean exists(String accountId, String roleId);
}
