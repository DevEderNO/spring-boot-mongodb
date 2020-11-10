package com.devederno.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private String text;
  private Date date;
  private AuthorDTO author;

  public CommentDTO() {
  }

  public CommentDTO(String text, Date date, AuthorDTO author) {
    this.date = date;
    this.text = text;
    this.author = author;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getText() {
    return text;
  }

  public void setText(String title) {
    this.text = title;
  }

  public AuthorDTO getAuthor() {
    return author;
  }

  public void setAuthor(AuthorDTO author) {
    this.author = author;
  }
}
