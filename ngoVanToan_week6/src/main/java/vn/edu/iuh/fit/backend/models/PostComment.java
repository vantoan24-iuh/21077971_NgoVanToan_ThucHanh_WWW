package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "post_comment")
@NamedQueries({
        @NamedQuery(name = "getAllPostComment", query = "select p from PostComment p"),
        @NamedQuery(name = "getPostCommentById", query = "select p from PostComment p where p.id = :id"),
        @NamedQuery(name = "updatePostComment", query = "update PostComment p set p.post = :post, p.parent = :parent, p.title = :title, p.published = :published, p.createdAt = :createdAt, p.publishedAt = :publishedAt, p.content = :content, p.user = :user where p.id = :id"),
        @NamedQuery(name = "deletePostComment", query = "delete from PostComment p where p.id = :id")
})
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private PostComment parent;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "published", nullable = false)
    private Boolean published = false;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "publishedAt")
    private Instant publishedAt;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;


}