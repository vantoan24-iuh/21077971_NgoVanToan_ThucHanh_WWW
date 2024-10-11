package vn.edu.iuh.fit.lab_week1.repositories.imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.lab_week1.entities.Account;
import vn.edu.iuh.fit.lab_week1.repositories.AccountRepository;

import java.util.List;

public class AccountRepositoryImp implements AccountRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public AccountRepositoryImp() {
        entityManager = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
        entityTransaction = this.entityManager.getTransaction();
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = entityManager.createNamedQuery("Account.findAll", Account.class).getResultList();
        return accounts;
    }

    @Override
    public Account findById(String id) {
        try {
            return entityManager.createNamedQuery("Account.findByAccountIdOrderByAccountIdAsc", Account.class).setParameter("accountId", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAccountByRoleName(String roleName) {
        return List.of();
    }

    @Override
    public List<Account> findAccountByRoleId(String roleName) {

        return List.of();
    }

    @Override
    public boolean exists(String id) {
        try {
            return entityManager.createNamedQuery("Account.findByAccountIdOrderByAccountIdAsc", Account.class).setParameter("accountId", id).getSingleResult() != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(Account account) {
        try {
            entityTransaction.begin();
            entityManager.persist(account);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public Account update(Account account) {
        try {
            entityTransaction.begin();
            entityManager.merge(account);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Account account) {
        try {
            entityTransaction.begin();
            entityManager.remove(account);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }
}
