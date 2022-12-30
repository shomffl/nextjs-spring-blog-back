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

  public List<PostDTO> getAllPosts() {

    return postRepository.findAll().stream().map(PostDTO::of).collect(Collectors.toList());
  }
}
