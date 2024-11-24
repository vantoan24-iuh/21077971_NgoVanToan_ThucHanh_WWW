package vn.edu.iuh.fit.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Post;

import java.util.List;

@Component
public interface PostServices {
    Page<Post> getAllPostPage(int pageNo, int pageSize, String sortBy, String sortDirection);
    List<Post> getAllPostNoPage();
    Post getPostById(int id);
    boolean addPost(Post post);
    boolean updatePost(Post post);
    boolean deletePost(int id);
}
