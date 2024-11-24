package vn.edu.iuh.fit.backend.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.PostComment;
import vn.edu.iuh.fit.backend.repositoty.PostCommentRepository;
import vn.edu.iuh.fit.backend.repositoty.PostRepository;
import vn.edu.iuh.fit.backend.services.PostCommentServices;

import java.util.List;

@Service
public class PostCommentServicesImp implements PostCommentServices {

    @Autowired
    private PostCommentRepository postCommentRepository;

    @Override
    public Page<PostComment> getAllPostCommentPage(int pageNo, int pageSize, String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public List<PostComment> getAllPostCommentNoPage() {
        return postCommentRepository.findAll() ;
    }

    @Override
    public PostComment getPostCommentById(int id) {
        return null;
    }

    @Override
    public boolean addPostComment(PostComment postComment) {
        postComment.setPost(postComment.getPost());
        postComment.setUser(postComment.getUser());
        postComment.setContent(postComment.getContent());
        postComment.setCreatedAt(postComment.getCreatedAt());
        postComment.setParent(postComment.getParent());
        postComment.setTitle(postComment.getTitle());
        postComment.setPublished(postComment.getPublished());
        postComment.setPublishedAt(postComment.getPublishedAt());

        postCommentRepository.save(postComment);
        return true;
    }

    @Override
    public boolean updatePostComment(PostComment postComment) {
        return false;
    }

    @Override
    public boolean deletePostComment(int id) {
        return false;
    }
}
