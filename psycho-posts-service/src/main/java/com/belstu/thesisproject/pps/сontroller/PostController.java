package com.belstu.thesisproject.pps.сontroller;

import com.belstu.thesisproject.pps.domain.PsychoPost;
import com.belstu.thesisproject.pps.exception.AuthorNotFoundException;
import com.belstu.thesisproject.pps.exception.PostNotFoundException;
import com.belstu.thesisproject.pps.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/posts")
@Validated
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/{id}")
    public PsychoPost getPostById(
            @PathVariable final String id) throws PostNotFoundException {
        return postService.getPostById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PsychoPost> getPostByAuthorId(
            @PathVariable final String id) throws AuthorNotFoundException {
        return postService.getAllPostsByAuthorId(id);
    }

    @GetMapping("/posts")
    public List<PsychoPost> getAllPosts() {
        return postService.getAllPost();
    }

    @PostMapping
    public PsychoPost savePost(
            @RequestBody final PsychoPost post) {
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = OK)
    public void deletePost(
            @PathVariable final String id) throws PostNotFoundException {
        postService.delete(id);
    }

}
