package vn.edu.iuh.fit.lab_week1.repositories.imp;

import vn.edu.iuh.fit.lab_week1.entities.GrantAccess;
import vn.edu.iuh.fit.lab_week1.repositories.GrantAccessRepository;

import java.util.List;

public class GrantAccessRepositoryImp implements GrantAccessRepository {
    @Override
    public List<GrantAccess> findAccountByRoleId(String roleId) {
        return List.of();
    }

    @Override
    public List<GrantAccess> findRoleByAccountId(String accountId) {
        return List.of();
    }

    @Override
    public boolean save(GrantAccess grantAccess) {
        return false;
    }

    @Override
    public boolean delete(GrantAccess grantAccess) {
        return false;
    }

    @Override
    public boolean exists(String accountId, String roleId) {
        return false;
    }
}
