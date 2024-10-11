package vn.edu.iuh.fit.lab_week1.services;

import vn.edu.iuh.fit.lab_week1.entities.Account;
import vn.edu.iuh.fit.lab_week1.repositories.AccountRepository;
import vn.edu.iuh.fit.lab_week1.repositories.RoleRepository;
import vn.edu.iuh.fit.lab_week1.repositories.imp.AccountRepositoryImp;
import vn.edu.iuh.fit.lab_week1.repositories.imp.RoleRepositoryImp;

public class AccountServices {
    private AccountRepository accountRepository;
    private RoleRepository roleRepository;


    public AccountServices() {
        this.accountRepository = new AccountRepositoryImp();
        roleRepository = new RoleRepositoryImp();
    }

public boolean addAccount(Account account) {
        if (check(account)) {
            return false;
        } else {
            accountRepository.add(account);
            return true;
        }
    }

    private boolean check(Account account) {
        return accountRepository.exists(account.getAccountId());
    }

}


