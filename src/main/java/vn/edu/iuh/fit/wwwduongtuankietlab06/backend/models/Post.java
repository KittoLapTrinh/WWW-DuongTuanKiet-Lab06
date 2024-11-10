package vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "bit(1)")
    private Boolean published;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<PostComment> postComments;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post parent;
    @Column(name = "meta_title",length = 100)
    private String metaTitle;
    private String summary;
    @Column(name = "created_at")
    private Instant createdAt;
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
    private Set<Post> posts;
    @Column(length = 75)
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @Column(name = "updated_at")
    private Instant updatedAt;
    @Column(name = "published_at")
    private Instant publishedAt;
}
