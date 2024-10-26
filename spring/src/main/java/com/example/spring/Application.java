package com.example.spring;

import com.example.spring.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring.resposities.AccoutRespository;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Autowired
    private AccoutRespository accountRespository;

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();

//        for(long i = 0; i < 10; i++){
//            Account account = new Account(i, "name " + i, random.nextInt(1000));
//            accountRespository.save(account);
//        }
//        accountRespository.findAll().forEach(System.out::println);


        PageRequest pageRequest = PageRequest.of(0, 5);
//        Page<Account> accounts = accountRespository.findAll(pageRequest);
////        List<Account> accountList = accounts.getContent();
////        accountList.forEach(System.out::println);

        accountRespository.findByBalanceGreaterThan(500.0, pageRequest).
                forEach(System.out::println);
    }

}
