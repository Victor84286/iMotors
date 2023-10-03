package br.edu.ibmec.cloudcomputing.imotors.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "comment")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime dtComment;

    @Column(nullable = false)
    @NotBlank(message = "Campo texto do comentario não pode ser vazio")
    private String text;

    @Column(nullable = false)
    @NotBlank(message = "Campo autor do comentario não pode ser vazio")
    private String author;

    @ManyToOne
    private Post post;

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public LocalDateTime getDtComment() {
        return dtComment;
    }
    public void setDtComment(LocalDateTime dtComment) {
        this.dtComment = dtComment;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

}
