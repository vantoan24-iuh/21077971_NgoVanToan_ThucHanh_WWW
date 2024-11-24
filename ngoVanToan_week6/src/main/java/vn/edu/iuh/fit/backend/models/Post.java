package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "post")
@NamedQueries({
        @NamedQuery(name = "getAllPost", query = "select p from Post p"),
        @NamedQuery(name = "getPostById", query = "select p from Post p where p.id = :id"),
        @NamedQuery(name = "updatePost", query = "update Post p set p.author = :author, p.parent = :parent, p.title = :title, p.metaTitle = :metaTitle, p.summary = :summary, p.published = :published, p.createdAt = :createdAt, p.updatedAt = :updatedAt, p.publishedAt = :publishedAt, p.content = :content where p.id = :id"),
        @NamedQuery(name = "deletePost", query = "delete from Post p where p.id = :id")
})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "authorId", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Post parent;

    @Column(name = "title", nullable = false, length = 75)
    private String title;

    @Column(name = "metaTitle", length = 100)
    private String metaTitle;

    @Lob
    @Column(name = "summary")
    private String summary;

    @Column(name = "published", nullable = false)
    private Boolean published = false;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updatedAt;

    @Column(name = "publishedAt")
    private Instant publishedAt;

    @Lob
    @Column(name = "content")
    private String content;

}