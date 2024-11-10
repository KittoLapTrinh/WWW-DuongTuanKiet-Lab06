package vn.edu.iuh.fit.wwwduongtuankietlab06.frontend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.Post;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.PostCommentRepository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.PostRepository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.services.PostService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    @GetMapping("/post")
    public String showPostListPaging(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<Post> postPage = postService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("postPage", postPage);
        model.addAttribute("currentPage", postPage.getNumber() + 1);
        model.addAttribute("pageSize", size);
        int totalPages = postPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "post/post-page";
    }

    @GetMapping("/blog")
    public String showBlogs(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> blogPage = postService.findPaginated(PageRequest.of(currentPage -1, pageSize));
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("currentPage", blogPage.getNumber() + 1);
        model.addAttribute("pageSize", pageSize);
        int totalPages = blogPage.getTotalPages();
        if(totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "post/blog-page";
    }



}
