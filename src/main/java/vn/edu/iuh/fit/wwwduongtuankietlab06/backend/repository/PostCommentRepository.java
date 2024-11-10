package vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.PostComment;

import java.util.List;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    List<PostComment> getPostCommentsByPostId(long id);
}
