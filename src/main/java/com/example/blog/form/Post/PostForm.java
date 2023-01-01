package com.example.blog.form.Post;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PostForm {
  @NotBlank(message = "titleに値が入力されていません")
  private String title;

  @NotBlank(message = "bodyに値が入力されていません")
  private String body;
}
