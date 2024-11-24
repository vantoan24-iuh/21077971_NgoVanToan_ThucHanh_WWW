package vn.edu.iuh.fit.backend.repositoty;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//    List<User> getAllUser(Pageable pageable);
}
