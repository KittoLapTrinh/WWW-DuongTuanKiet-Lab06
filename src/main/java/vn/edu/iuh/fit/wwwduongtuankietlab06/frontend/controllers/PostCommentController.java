package vn.edu.iuh.fit.wwwduongtuankietlab06.frontend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.Post;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.PostComment;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.User;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.PostCommentRepository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.PostRepository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.UserRepository;

import java.time.Instant;

@Controller
@RequiredArgsConstructor
public class PostCommentController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    @PostMapping("/insert-comment/{id}")
    public String addPostComment(
            @RequestParam("email") String email,
            @RequestParam("content") String content,
            @PathVariable("id") long id) {
        PostComment postComment = new PostComment();
        postComment.setContent(content);
        postComment.setCreatedAt(Instant.now());
        postComment.setPublishedAt(Instant.now());
        User user = userRepository.getUserByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Not found email " + email));

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id " + id));
        System.out.println("User is: " + user);
        System.out.println("Post is: " + post);
        postComment.setUser(user);
        postComment.setPost(post);
        postComment.setTitle(user.getFullName());
        postCommentRepository.save(postComment);
        return "redirect:/show-blog-detail/{id}";
    }

}
