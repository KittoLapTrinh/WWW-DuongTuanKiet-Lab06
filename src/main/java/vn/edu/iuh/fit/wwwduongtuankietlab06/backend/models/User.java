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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15)
    private String mobile;
    @Column(name = "last_login")
    private Instant lastLogin;
    @Column(length = 50, name = "last_name")
    private String lastName;
    @Column(columnDefinition = "TINYTEXT")
    private String intro;
    @Column(columnDefinition = "TEXT")
    private String profile;
    @Column(name = "registered_at")
    private Instant registeredAt;
    @Column(name = "password_hash")
    private String passwordHash;
    @Column(length = 50, name = "middle_name")
    private String middleName;
    @Column(length = 50, name = "first_name")
    private String firstName;
    @Column(length = 50)
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<PostComment> postComments;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;

    public String getFullName() {
        return this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName();
    }
}