package com.example.spring.resposities;

import com.example.spring.models.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccoutRespository extends JpaRepository<Account, Long>{
    List<Account> findByBalanceGreaterThan(double balance, Pageable pageable);
}
