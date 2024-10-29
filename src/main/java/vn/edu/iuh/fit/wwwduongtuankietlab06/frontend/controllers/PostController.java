package vn.edu.iuh.fit.wwwduongtuankietlab06.frontend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.PostCommentRepository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.PostRepository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.services.PostService;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;


}
