package vn.edu.iuh.fit.backend.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
