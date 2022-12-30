package com.example.blog.controller.Post;

import com.example.blog.dto.Post.PostDTO;
import com.example.blog.service.Post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @GetMapping("/api/posts")
  public List<PostDTO> getPosts() {
    return postService.getAllPosts();
  }
}
