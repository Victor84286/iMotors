package br.edu.ibmec.cloudcomputing.imotors.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false)
    @NotBlank(message = "Campo autor do post não pode ser vazio")
    private String author;

    @Column(nullable = false)
    private LocalDateTime dtPublish;

    @Column(nullable = false)
    @NotBlank(message = "Campo título do post não pode ser vazio")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Campo texto do post não pode ser vazio")
    private String article;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Comments> comments;

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public LocalDateTime getDtPublish() {
        return dtPublish;
    }

    public void setDtPublish(LocalDateTime dtPublish) {
        this.dtPublish = dtPublish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public void addComment(Comments comment){
        this.comments.add(comment);
    }

}
