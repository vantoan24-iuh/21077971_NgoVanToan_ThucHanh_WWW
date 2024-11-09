package vn.edu.iuh.fit.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Application {
    public static EntityManager entityManager(){
        return Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    public static void main(String[] args) {
        System.out.println(entityManager());
    }
}
