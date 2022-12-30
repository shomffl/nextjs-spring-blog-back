package com.example.blog.entity.Post;

import com.example.blog.form.Post.PostForm;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String title;

  private String body;

  @CreationTimestamp private LocalDateTime createTime;
  @UpdateTimestamp private LocalDateTime updateTime;

  public static Post of(PostForm postForm) {
    Post post = new Post();
    post.setTitle(postForm.getTitle());
    post.setBody(postForm.getBody());

    return post;
  }
}
