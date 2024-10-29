package vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
