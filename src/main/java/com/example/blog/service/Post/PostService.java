package com.example.blog.service.Post;

import com.example.blog.dto.Post.PostDTO;
import com.example.blog.repository.Post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  /**
   * 投稿全件取得
   *
   * @return 全投稿データ
   */
  public List<PostDTO> getAllPosts() {

    return postRepository.findAll().stream().map(PostDTO::of).collect(Collectors.toList());
  }

  /**
   * 投稿検索処理(id)
   *
   * @param id 投稿id
   * @return 投稿データ
   */
  public PostDTO searchPostById(Long id) {
    return PostDTO.of(postRepository.findById(id).get());
  }
}
