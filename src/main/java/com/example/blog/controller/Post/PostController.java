package com.example.blog.controller.Post;

import com.example.blog.dto.Post.PostDTO;
import com.example.blog.form.Post.PostForm;
import com.example.blog.service.Post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  private final String FRONT_URL = "http://localhost:3000";

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
  public PostDTO savePost(@Valid @RequestBody PostForm postForm) {
    return postService.savePost(postForm);
  }

  /**
   * 投稿編集処理
   *
   * @param id 投稿id
   * @param postForm 入力値
   * @return 保存データ
   */
  @PutMapping("/api/posts/edit/{id}")
  public PostDTO editPost(@PathVariable("id") Long id, @RequestBody PostForm postForm) {
    return postService.updatePost(id, postForm);
  }

  /**
   * 投稿削除処理
   *
   * @param id 投稿id
   */
  @DeleteMapping("/api/posts/{id}")
  public void deletePost(@PathVariable("id") Long id) {
    postService.deletePost(id);
  }
}
