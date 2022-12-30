package com.example.blog.dto.Post;

import com.example.blog.entity.Post.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDTO {

  private Long Id;
  private String title;
  private String body;
  private LocalDateTime CreateTime;
  private LocalDateTime UpdateTime;

  public static PostDTO of(Post post) {
    PostDTO postDTO = new PostDTO();
    postDTO.setId(post.getId());
    postDTO.setTitle(post.getTitle());
    postDTO.setBody(post.getBody());
    postDTO.setCreateTime(post.getCreateTime());
    postDTO.setUpdateTime(post.getUpdateTime());

    return postDTO;
  }
}
