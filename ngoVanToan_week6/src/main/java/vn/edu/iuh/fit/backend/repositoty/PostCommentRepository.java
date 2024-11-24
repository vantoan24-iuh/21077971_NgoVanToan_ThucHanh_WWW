package vn.edu.iuh.fit.backend.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.PostComment;

import java.util.List;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long>{


}
