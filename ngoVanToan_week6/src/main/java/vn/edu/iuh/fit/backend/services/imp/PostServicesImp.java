package vn.edu.iuh.fit.backend.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Post;
import vn.edu.iuh.fit.backend.repositoty.PostRepository;
import vn.edu.iuh.fit.backend.services.PostServices;

import java.util.List;

@Service
public class PostServicesImp implements PostServices {

    @Autowired
    private PostRepository postRepository;
    @Override
    public Page<Post> getAllPostPage(int pageNo, int pageSize, String sortBy, String sortDirection) {
        return null;
    }
    @Override
    public List<Post> getAllPostNoPage() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(int id) {
        return null;
    }

    @Override
    public boolean addPost(Post post) {
        post.setAuthor(post.getAuthor());
        post.setParent(post.getParent());
        post.setTitle(post.getTitle());
        post.setMetaTitle(post.getMetaTitle());
        post.setSummary(post.getSummary());
        post.setPublished(post.getPublished());
        post.setCreatedAt(post.getCreatedAt());
        post.setUpdatedAt(post.getUpdatedAt());
        post.setPublishedAt(post.getPublishedAt());
        post.setContent(post.getContent());

        postRepository.save(post);
        return true;
    }

    @Override
    public boolean updatePost(Post post) {
        return false;
    }

    @Override
    public boolean deletePost(int id) {
        return false;
    }
}
