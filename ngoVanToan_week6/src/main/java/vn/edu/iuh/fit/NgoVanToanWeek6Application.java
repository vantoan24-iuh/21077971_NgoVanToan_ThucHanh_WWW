package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.models.Post;
import vn.edu.iuh.fit.backend.models.PostComment;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositoty.PostCommentRepository;
import vn.edu.iuh.fit.backend.services.PostCommentServices;
import vn.edu.iuh.fit.backend.services.PostServices;
import vn.edu.iuh.fit.backend.services.UserServices;
import vn.edu.iuh.fit.backend.services.imp.PostCommentServicesImp;
import vn.edu.iuh.fit.backend.services.imp.PostServicesImp;
import vn.edu.iuh.fit.backend.services.imp.UserServicesImp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NgoVanToanWeek6Application {
    @Autowired
    private UserServicesImp userService;

    @Autowired
    private PostServicesImp postService;

    @Autowired
    private PostCommentServicesImp postCommentService;

    public static void main(String[] args) {
        SpringApplication.run(NgoVanToanWeek6Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostCommentRepository postCommentRepository) {
        return args -> {
            List<User> users = new ArrayList<>();  // Fixed syntax error here
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setFirstName("User" + i);
                user.setMiddleName("Middle" + i);
                user.setLastName("Test" + i);
                user.setEmail("user" + i + "@test.com");
                user.setMobile("123456789" + i);
                user.setPasswordHash("password" + i);
                user.setRegisteredAt(Instant.now());
                user.setLastLogin(Instant.now());
                user.setIntro("Hello, I am user " + i);
                user.setProfile("This is profile of user " + i);
                users.add(user);
            }

            // Save all users
            users.forEach(user -> userService.addUser(user));

            // Create and save posts for each user
            users.forEach(user -> {
                for (int i = 0; i < 2; i++) {
                    Post post = new Post();
                    post.setAuthor(user);
                    post.setTitle("Post " + i + " by " + user.getFirstName());
                    post.setMetaTitle("Meta Title " + i);
                    post.setSummary("Summary of post " + i);
                    post.setPublished(true);
                    post.setCreatedAt(Instant.now());
                    post.setContent("Content of post " + i);
                    boolean savedPost = postService.addPost(post);

                    // Create comments for each post
                    for (int j = 0; j < 2; j++) {
                        PostComment comment = new PostComment();
                        comment.setPost(savedPost ? post : null);
                        comment.setUser(user);
                        comment.setTitle("Comment " + j + " on post " + i);
                        comment.setPublished(true);
                        comment.setCreatedAt(Instant.now());
                        comment.setContent("This is comment " + j + " content");
                        postCommentService.addPostComment(comment);
                    }
                }
            });
        };
    }
}
