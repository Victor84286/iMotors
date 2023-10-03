package br.edu.ibmec.cloudcomputing.imotors.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.cloudcomputing.imotors.model.Post;
import br.edu.ibmec.cloudcomputing.imotors.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post create(Post post){
        if(post.getDtPublish() == null){
            post.setDtPublish(LocalDateTime.now());
        }

        return this.postRepository.save(post);
    }

    public Optional<Post> getById(long id){
        return this.postRepository.findById(id);
    }

    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    public void saveOrUpdate(Post item){
        this.postRepository.save(item);
    }

    public Post update(long id, Post newData) throws Exception{
        Optional<Post> oldPost = this.postRepository.findById(id);
        if(oldPost.isPresent() == false){
            throw new Exception("Não encontrei o post a ser atualizado");
        }

        Post post = oldPost.get();
        post.setTitle(newData.getTitle());
        post.setArticle(newData.getArticle());
        post.setAuthor(newData.getAuthor());

        this.postRepository.save(post);
        return post;
    }

    public void delete(long id) throws Exception {
        Optional<Post> oldPost = this.postRepository.findById(id);
        if(oldPost.isPresent() == false){
            throw new Exception("Não encontrei o post a ser atualizado");
        }

        this.postRepository.delete(oldPost.get());

        }
}
