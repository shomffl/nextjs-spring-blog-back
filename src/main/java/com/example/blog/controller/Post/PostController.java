package com.example.blog.controller.Post;

import com.example.blog.dto.Post.PostDTO;
import com.example.blog.form.Post.PostForm;
import com.example.blog.service.Post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  /**
   * 投稿全件取得処理
   *
   * @return 投稿データ
   */
  @GetMapping("/api/posts")
  public List<PostDTO> getPosts() {
    return postService.getAllPosts();
  }

  /**
   * 投稿取得処理（id)
   *
   * @param id 投稿id
   * @return 投稿データ
   */
  @GetMapping("/api/posts/{id}")
  public PostDTO getPost(@PathVariable("id") Long id) {
    return postService.searchPostById(id);
  }

  /**
   * 投稿保存処理
   *
   * @param postForm 入力値
   * @return 保存データ
   */
  @PostMapping("/api/posts")
  public PostDTO savePost(@RequestBody PostForm postForm) {
    return postService.savePost(postForm);
  }
}
