package vn.edu.iuh.fit.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.models.PostComment;

import java.util.List;

@Component
public interface PostCommentServices {
    Page<PostComment> getAllPostCommentPage(int pageNo, int pageSize, String sortBy, String sortDirection);
    List<PostComment> getAllPostCommentNoPage();
    PostComment getPostCommentById(int id);
    boolean addPostComment(PostComment postComment);
    boolean updatePostComment(PostComment postComment);
    boolean deletePostComment(int id);

}
