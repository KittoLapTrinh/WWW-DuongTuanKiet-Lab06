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
@Table(name = "post_comment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PostComment parent;
    @Transient
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @Column(length = 100)
    private String title;
    @Column(columnDefinition = "bit(1)")
    private Boolean published;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(name = "published_at")
    private Instant publishedAt;
    @Column(name = "created_at")
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
