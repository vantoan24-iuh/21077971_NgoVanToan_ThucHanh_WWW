package vn.edu.iuh.fit.lab_week1.repositories;

import vn.edu.iuh.fit.lab_week1.entities.Account;

import java.util.List;

public interface AccountRepository {
    public List<Account> findAll();
    public Account findById(String id);
    public List<Account> findAccountByRoleName(String roleName);
    public List<Account> findAccountByRoleId(String roleName);
    public boolean exists(String id);
    public void save(Account account);
    public Account update(Account account);
    public boolean delete(Account account);
}
