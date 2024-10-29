package vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> getUserByEmail(String email);

}
